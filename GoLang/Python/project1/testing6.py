import re
import csv

# reading in both files
with open('Baselight_export.txt', 'r') as fileA:
    baselight = fileA.read()
with open('Xytech.txt', 'r') as fileB:
    xytech = fileB.read()

# extract the numerical values from the Baselight file
nums = re.findall(r'\d+', baselight)

# iterate over the lines in the Xytech file
out = []
for line in xytech.splitlines():
    # if the line contains a path, add the sequential numerical values
    if 'production' in line:
        path, *rest = line.split()
        seq_nums = []
        for num in nums:
            if path in baselight and num in baselight.split():
                seq_nums.append(num)
            else:
                break
        # if there are sequential numerical values, add them as a new line to the output
        if seq_nums:
            out.append([path] + seq_nums)

# write the output to a csv file
with open('output.csv', 'w', newline='') as fileC:
    writer = csv.writer(fileC)
    writer.writerows(out)
