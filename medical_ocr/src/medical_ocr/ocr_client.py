"""Client for interacting with the OpenAI OCR-capable models."""
from __future__ import annotations

import base64
import json
import logging
from pathlib import Path
from typing import Any, Dict

from openai import OpenAI

logger = logging.getLogger(__name__)


class OpenAIMedicalOCR:
    """Wraps the OpenAI Responses API to extract medical data from images."""

    def __init__(self, model: str = "gpt-4o-mini", client: OpenAI | None = None) -> None:
        self.model = model
        self.client = client or OpenAI()

    def _encode_image(self, image_path: Path) -> str:
        with image_path.open("rb") as image_file:
            return base64.b64encode(image_file.read()).decode("ascii")

    def extract_medical_data(self, image_path: Path) -> Dict[str, Any]:
        """Send *image_path* to the OpenAI API and return the parsed JSON response."""

        logger.debug("Sending page to OpenAI", extra={"path": str(image_path)})
        image_b64 = self._encode_image(image_path)

        response = self.client.responses.create(
            model=self.model,
            input=[
                {
                    "role": "system",
                    "content": [
                        {
                            "type": "text",
                            "text": (
                                "You are a meticulous medical records transcription system. "
                                "Return JSON with two keys: 'extracted_text' (string) containing the full "
                                "transcribed text, and 'medical_data' (object) capturing structured medical "
                                "details such as patient demographics, diagnoses, medications, lab results, "
                                "vital signs, provider information, and dates. Use arrays when multiple values "
                                "are present. If a field is missing, omit it."
                            ),
                        }
                    ],
                },
                {
                    "role": "user",
                    "content": [
                        {
                            "type": "input_text",
                            "text": "Transcribe this medical document page and extract structured data.",
                        },
                        {
                            "type": "input_image",
                            "image_url": f"data:image/png;base64,{image_b64}",
                        },
                    ],
                },
            ],
            response_format={"type": "json_object"},
        )

        try:
            raw_text = response.output[0].content[0].text
        except (AttributeError, IndexError) as exc:  # pragma: no cover - defensive
            logger.error("Unexpected response format from OpenAI: %s", response)
            raise RuntimeError("Failed to parse response from OpenAI") from exc

        data = json.loads(raw_text)
        logger.debug("Received OpenAI response", extra={"keys": list(data.keys())})
        return data
