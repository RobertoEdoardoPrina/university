# import

import sys
import re
import pysam
from pysam import AlignmentFile

# input

gtf_file_name = sys.argv[1]
pysam.index(sys.argv[2])
bam_file = AlignmentFile(sys.argv[2], 'rb')
tolerance = int(sys.argv[3])

# choice of feature - exon

selected_feature = 'exon'

# function that finds the transcript from the gtf

def get_transcript(gtf_record):
        
    transcript_id = re.search(r'transcript_id\s+"(.+?)";', gtf_record).group(1)
    
    return transcript_id

# selection of GTF records used to reconstruct exon sequences

with open(gtf_file_name, 'r') as input_file:
    
    gtf_records = input_file.readlines()

selected_gtf_records = [rec for rec in gtf_records if rec.split('\t')[2] == selected_feature]

# dictionary construction with the transcript as key and the tuple composed of the strands as value

exon_dict = {}

for gtf_record in selected_gtf_records:
    strand1 = gtf_record.split('\t')[3]
    strand2 = gtf_record.split('\t')[4]
    
    transcript_id = get_transcript(gtf_record)
    
    tuplaStrand = (int(strand1), int(strand2))


    if transcript_id in exon_dict:
      exon_dict[transcript_id].append(tuplaStrand)
    else:
      exon_dict[transcript_id] = []
      exon_dict[transcript_id].append(tuplaStrand)

# new dictionary in which I take as key the value from the dictionary 
# of exons and as value the next to the second and the previous to the first

intro_dict = {}
for key, value in exon_dict.items():
    new_intervals = []
    for i in range(len(value) - 1):
        new_tuple = (value[i][1] + 1, value[i+1][0] - 1)
        new_intervals.append(new_tuple)
    intro_dict[key] = new_intervals

alignment_iter = bam_file.fetch()
alignment_list = list(alignment_iter)

# search for introns in the bam file

for key, intervals in intro_dict.items():
    counter = 0
    for alignment in alignment_list:
        introns = []
        ctuples = alignment.cigartuples
        for ix, cig in enumerate(ctuples):
            if cig[0] == 3:
                offset = sum(ctuples[_ix][1] for _ix in range(ix))
                intron_start = alignment.reference_start + offset
                intron_end = intron_start + cig[1]
                introns.append((intron_start, intron_end))
        
        # for each intron found I check with how many of the intron dictionary is aligned
            
        for pair in introns:
            for interval in intervals:
                if ((pair[0] - interval[0])in range(-tolerance, tolerance)) and ((pair[1] - interval[1])in range(-tolerance, tolerance)):
                    counter += 1
                    break

    # result for each transcript_id

    print("For the transcript "+ str(key) +" there are "+ str(counter)+" reads of the file "+sys.argv[2]+" that support it")
