"""Domain models used across the medical OCR pipeline."""
from __future__ import annotations

from dataclasses import dataclass
from pathlib import Path
from typing import Any, Dict, List, Optional


@dataclass(slots=True)
class PageExtraction:
    """Container for the information extracted from a single PDF page."""

    page_number: int
    image_path: Path
    raw_text: str
    medical_data: Dict[str, Any]


@dataclass(slots=True)
class ExtractionSummary:
    """Summary of the entire extraction run."""

    pdf_path: Path
    output_directory: Path
    text_output: Path
    json_output: Path
    page_results: List[PageExtraction]
    model: str
    password_protected: bool = False


@dataclass(slots=True)
class PipelineConfig:
    """Configuration shared across the pipeline components."""

    pdf_path: Path
    output_directory: Path
    text_output: Optional[Path] = None
    json_output: Optional[Path] = None
    password: Optional[str] = None
    model: str = "gpt-4o-mini"
    dpi: int = 300

    def resolved_text_output(self) -> Path:
        if self.text_output is not None:
            return self.text_output
        return self.output_directory / "medical_data.txt"

    def resolved_json_output(self) -> Path:
        if self.json_output is not None:
            return self.json_output
        return self.output_directory / "medical_data.json"
