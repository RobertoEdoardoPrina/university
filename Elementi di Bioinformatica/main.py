# import dei moduli

import sys
import re
import pysam
from pysam import AlignmentFile

# parametri in input

gtf_file_name = sys.argv[1]
pysam.index(sys.argv[2])
bam_file = AlignmentFile(sys.argv[2], 'rb')
tolleranza = int(sys.argv[3])

# scelta della feature - esone

selected_feature = 'exon'

# funzione che trova dal gtf il trascritto

def get_transcript(gtf_record):
        
    transcript_id = re.search(r'transcript_id\s+"(.+?)";', gtf_record).group(1)
    
    return transcript_id

# selezione dei record GTF che servono per ricostruire le sequenze di esoni

with open(gtf_file_name, 'r') as input_file:
    
    gtf_records = input_file.readlines()

selected_gtf_records = [rec for rec in gtf_records if rec.split('\t')[2] == selected_feature]

# costruzione dei dizionario che ha come chiave il trascritto e come valore la tupla composta dagli strand

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

# nuovo dizionario in cui prendo come chiave il valore dal dizionario 
# di esoni e come valore il successivo al secondo ed il precedente al primo

intro_dict = {}
for key, value in exon_dict.items():
    new_intervals = []
    for i in range(len(value) - 1):
        new_tuple = (value[i][1] + 1, value[i+1][0] - 1)
        new_intervals.append(new_tuple)
    intro_dict[key] = new_intervals

alignment_iter = bam_file.fetch()
alignment_list = list(alignment_iter)

# ricerca degli introni nel file bam

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
        
        # per ogni introne trovato controllo con quanti del dizionario di introni è allineato

        for pair in introns:
            for interval in intervals:
                if ((pair[0] - interval[0])in range(-tolleranza, tolleranza)) and ((pair[1] - interval[1])in range(-tolleranza, tolleranza)):
                    counter += 1
                    break

    # risultato per ogni trascritto

    print("Per il trascritto "+ str(key) +" vi sono "+ str(counter)+" reads del file "+sys.argv[2]+" che lo supportano")