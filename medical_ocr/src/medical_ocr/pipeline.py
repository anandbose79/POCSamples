"""End-to-end pipeline for extracting medical data from PDFs using OpenAI OCR."""
from __future__ import annotations

import json
import logging
from pathlib import Path
from typing import Iterable, List

from .models import ExtractionSummary, PageExtraction, PipelineConfig
from .ocr_client import OpenAIMedicalOCR
from .pdf_processor import PDFProcessor

logger = logging.getLogger(__name__)


def extract_medical_data(config: PipelineConfig) -> ExtractionSummary:
    """Run the full medical OCR pipeline for the supplied configuration."""

    pdf_path = config.pdf_path.expanduser().resolve()
    output_directory = config.output_directory.expanduser().resolve()
    text_output = config.resolved_text_output().expanduser().resolve()
    json_output = config.resolved_json_output().expanduser().resolve()

    logger.info("Starting extraction", extra={"pdf": str(pdf_path)})

    pdf_processor = PDFProcessor(output_directory=output_directory / "images", dpi=config.dpi)
    ocr_client = OpenAIMedicalOCR(model=config.model)

    page_images = pdf_processor.convert(pdf_path, password=config.password)

    page_results: List[PageExtraction] = []
    for index, image_path in enumerate(page_images, start=1):
        response = ocr_client.extract_medical_data(image_path)
        page_results.append(
            PageExtraction(
                page_number=index,
                image_path=image_path,
                raw_text=response.get("extracted_text", ""),
                medical_data=response.get("medical_data", {}),
            )
        )

    _write_text_summary(text_output, page_results)
    _write_json_summary(json_output, page_results)

    logger.info("Extraction complete", extra={"pages": len(page_results)})

    return ExtractionSummary(
        pdf_path=pdf_path,
        output_directory=output_directory,
        text_output=text_output,
        json_output=json_output,
        page_results=page_results,
        model=config.model,
        password_protected=config.password is not None,
    )


def _write_text_summary(path: Path, page_results: Iterable[PageExtraction]) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    with path.open("w", encoding="utf-8") as file:
        for page in page_results:
            file.write(f"# Page {page.page_number}\n\n")
            file.write(page.raw_text.strip())
            file.write("\n\n")
    logger.debug("Wrote text summary", extra={"path": str(path)})


def _write_json_summary(path: Path, page_results: Iterable[PageExtraction]) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    serialisable = [
        {
            "page": page.page_number,
            "image": str(page.image_path),
            "extracted_text": page.raw_text,
            "medical_data": page.medical_data,
        }
        for page in page_results
    ]

    with path.open("w", encoding="utf-8") as file:
        json.dump(serialisable, file, indent=2, ensure_ascii=False)
    logger.debug("Wrote JSON summary", extra={"path": str(path)})
