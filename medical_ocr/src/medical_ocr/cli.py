"""Command-line interface for the medical OCR pipeline."""
from __future__ import annotations

import argparse
import logging
from pathlib import Path
from typing import Optional

from .models import PipelineConfig
from .pipeline import extract_medical_data

LOG_LEVELS = {"debug": logging.DEBUG, "info": logging.INFO, "warning": logging.WARNING}


def build_argument_parser() -> argparse.ArgumentParser:
    parser = argparse.ArgumentParser(description="Extract medical data from a PDF using OpenAI OCR.")
    parser.add_argument("pdf", type=Path, help="Path to the PDF file")
    parser.add_argument("output", type=Path, help="Directory to store results")
    parser.add_argument("--password", help="Password for encrypted PDFs", default=None)
    parser.add_argument(
        "--model",
        default="gpt-4o-mini",
        help="OpenAI model to use (e.g., gpt-4o, gpt-4o-mini)",
    )
    parser.add_argument("--text-output", type=Path, help="Optional path for the text summary")
    parser.add_argument("--json-output", type=Path, help="Optional path for the JSON output")
    parser.add_argument("--dpi", type=int, default=300, help="Image DPI when rendering the PDF")
    parser.add_argument(
        "--log-level",
        choices=LOG_LEVELS.keys(),
        default="info",
        help="Logging level",
    )
    return parser


def main(argv: Optional[list[str]] = None) -> int:
    parser = build_argument_parser()
    args = parser.parse_args(argv)

    logging.basicConfig(level=LOG_LEVELS[args.log_level], format="%(levelname)s: %(message)s")

    config = PipelineConfig(
        pdf_path=args.pdf,
        output_directory=args.output,
        text_output=args.text_output,
        json_output=args.json_output,
        password=args.password,
        model=args.model,
        dpi=args.dpi,
    )

    extract_medical_data(config)
    return 0


if __name__ == "__main__":  # pragma: no cover
    raise SystemExit(main())
