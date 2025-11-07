"""Utilities to convert password-protected PDFs into images."""
from __future__ import annotations

import logging
from pathlib import Path
from typing import List, Optional

from pdf2image import convert_from_path

logger = logging.getLogger(__name__)


class PDFProcessor:
    """Handles conversion of PDF pages into image files."""

    def __init__(self, output_directory: Path, dpi: int = 300) -> None:
        self.output_directory = output_directory
        self.dpi = dpi

    def convert(self, pdf_path: Path, password: Optional[str] = None) -> List[Path]:
        """Convert *pdf_path* into PNG images.

        Parameters
        ----------
        pdf_path:
            Path to the PDF document.
        password:
            Optional password for encrypted documents.

        Returns
        -------
        List[Path]
            Paths to the generated image files, one per page.
        """

        logger.debug("Starting PDF to image conversion", extra={"pdf": str(pdf_path)})
        self.output_directory.mkdir(parents=True, exist_ok=True)

        images = convert_from_path(
            str(pdf_path),
            dpi=self.dpi,
            fmt="png",
            userpw=password,
            output_folder=None,
        )

        image_paths: List[Path] = []
        for index, image in enumerate(images, start=1):
            image_path = self.output_directory / f"page_{index:03d}.png"
            image.save(image_path, "PNG")
            image_paths.append(image_path)
            logger.debug("Saved page image", extra={"page": index, "path": str(image_path)})

        logger.info(
            "Converted %s pages from %s", len(image_paths), pdf_path.name
        )
        return image_paths
