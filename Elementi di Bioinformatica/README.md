# Project 1 (one student)

Given a sample in BAM format and a set of transcripts in GTF format, produce a Python script (not a notebook) that outputs for each transcript as many reads as it supports. Also produce a snakemake file with the necessary rules for launching this script as the input files change.
Typically there may be cases that make the problem more and more complex, e.g. reads may not cover the entire transcript (e.g., transcript of 2,000 bases and reads of length 150); reads may not terminate exactly at the intron/exon cutoff positions; reads may have different mapping qualities; etc. It is not necessary to consider all possible cases but one can make assumptions and ignore cases that complicate the design. Therefore, it is necessary to specify which assumptions are made, obviously the evaluation will also take into account how many simplifications have been made.

