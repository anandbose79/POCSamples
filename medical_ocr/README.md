# Medical OCR Pipeline

This project demonstrates how to extract structured medical data from password-protected PDFs
using OpenAI's multimodal OCR capabilities.

## Features

- Converts PDF pages (including encrypted documents) into high-resolution images.
- Sends each page image to an OpenAI vision-capable model and requests structured JSON output.
- Aggregates the extracted data into both a human-readable text report and a machine-readable
  JSON file.

## Recommended OpenAI Model

The pipeline defaults to the [`gpt-4o-mini`](https://platform.openai.com/docs/models#gpt-4o-mini)
model. It offers fast, cost-effective multimodal understanding while maintaining strong accuracy
for OCR-style tasks. For the highest possible fidelity you can switch to the `gpt-4o` model, which
is more capable but also more expensive.

## Requirements

- Python 3.11+
- [Poppler](https://poppler.freedesktop.org/) utilities available on the system `PATH` (required
  by `pdf2image`).
- An OpenAI API key available in the `OPENAI_API_KEY` environment variable.

Install Python dependencies:

```bash
python -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt
```

## Usage

```bash
python -m medical_ocr.cli /path/to/Patient1V2.pdf ./output --password <PDF_PASSWORD>
```

The command will create an `output` directory containing:

- `images/` – PNG files for each page.
- `medical_data.txt` – concatenated transcription of each page.
- `medical_data.json` – structured data for every page.

Use `--model gpt-4o` to switch to the larger model if needed. Additional options are available via
`python -m medical_ocr.cli --help`.
