# Transcript Intron Alignment Analysis

## Project Overview

This project involves analyzing RNA sequencing data to identify introns supported by aligned reads from a BAM file. The analysis is designed to reconstruct exon sequences from a GTF file and determine the alignment of reads within intronic regions. The program is implemented using Python with the `pysam` library, which provides tools for reading and manipulating alignment files, particularly BAM files.

## Problem Statement

The goal is to identify and count reads from a BAM file that support the existence of introns for each transcript specified in a GTF file. Introns are defined as the regions between consecutive exons, and the analysis is focused on ensuring that read alignments match expected intronic intervals within a specified tolerance.

## How the Solution Works

The program processes input data from a GTF file and a BAM file, identifying the exonic and intronic regions for each transcript. It then checks the BAM file to find reads that align with these intronic regions.

### Key Features

1. **Exon and Intron Identification**:
   - The script reads a GTF file to extract exon information for each transcript.
   - Introns are defined as the regions between consecutive exons.

2. **Alignment Analysis**:
   - The BAM file is indexed, and reads are fetched using `pysam`.
   - The script identifies intronic reads using CIGAR strings from the BAM file, focusing on segments with code `3` (representing introns).

3. **Tolerance-Based Matching**:
   - The alignment of each intron from the BAM file is compared against intronic intervals derived from the GTF file.
   - A user-defined tolerance is applied to allow for small deviations in the start and end positions of introns.

4. **Counting Supporting Reads**:
   - The script counts how many reads support the identified introns for each transcript and outputs the results.

## Input Files

1. **GTF File**: Contains transcript and exon information, used to determine exon positions and calculate intronic regions.
2. **BAM File**: Contains aligned reads from RNA sequencing data, which are checked against the intronic regions.
3. **Tolerance**: A user-defined value that specifies the allowable deviation between observed intronic positions and expected positions.

## How to Use

### Prerequisites

- Python installed on your system.
- `pysam` library installed (`pip install pysam`).

### Usage

Run the script using the following command:

```bash
python main.py <gtf_file> <bam_file> <tolerance>
```

- `<gtf_file>`: Path to the GTF file containing transcript annotations.
- `<bam_file>`: Path to the BAM file with aligned reads.
- `<tolerance>`: Integer value specifying the tolerance for intron alignment.

### Example

```bash
python main.py ENST00000466434.gtf sim.ENST00000296734.Aligned.sortedByCoord.out.bam 5
```

## Output

The program prints the number of reads from the BAM file that support introns for each transcript. For example:

```
For the transcript ENST00000466434 there are 15 reads of the file sim.ENST00000296734.Aligned.sortedByCoord.out.bam that support it.
```

## Conclusion

This tool provides a method for validating intronic regions in RNA sequencing data by comparing BAM file alignments against expected intronic intervals derived from GTF annotations. It is particularly useful for researchers analyzing splicing events and transcript structure in genomic data.

---

This README file provides an overview of the transcript intron alignment analysis tool, including its purpose, functionality, and usage instructions.
