import re
import csv

# reading in both files
with open('Baselight_export.txt', 'r') as fileA:
    baselight = fileA.read()
with open('Xytech.txt', 'r') as fileB:
    xytech = fileB.read()

# extract all the sequences of numbers from the Baselight file
sequences = re.findall(r'\d+(?:\s+\d+)*', baselight)

# split the lines of the Xytech file into a list
lines = xytech.split('\n')

# initialize a list to hold the modified lines of the Xytech file
modified_lines = []

# iterate over the lines of the Xytech file
for line in lines:
    # if the line starts with a '/', it's a location line
    if line.startswith('/'):
        # extract the location from the line
        location = line.strip()
        # initialize a list to hold the sequences of numbers for this location
        location_sequences = []
        # iterate over the sequences of numbers from the Baselight file
        for seq in sequences:
            # if the sequence starts with the location string, it belongs to this location
            if seq.startswith(location):
                # extract the numbers from the sequence
                numbers = seq[len(location):].strip()
                # split the numbers into a list
                numbers = numbers.split()
                # append the numbers to the location_sequences list
                location_sequences.extend(numbers)
        # if there are any sequences of numbers for this location, add them to the modified line
        if location_sequences:
            # join the numbers into a string with spaces between them
            seq_str = ' '.join(location_sequences)
            # add the sequence string to the modified line
            modified_line = line + ' ' + seq_str
            # add the modified line to the list of modified lines
            modified_lines.append(modified_line)
    # if the line doesn't start with a '/', it's not a location line, so add it to the modified lines list as-is
    else:
        modified_lines.append(line)

# open a new file to write the modified Xytech file to
with open('Xytech_modified.csv', 'w', newline='') as outfile:
    # create a CSV writer object
    writer = csv.writer(outfile, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
    # iterate over the modified lines of the Xytech file
    for line in modified_lines:
        # split the line on '/' to create columns
        cols = line.split('/')
        # write the columns to the CSV file
        writer.writerow(cols)