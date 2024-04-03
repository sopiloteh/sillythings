import re
import csv

# read in the Baselight_export.txt file and extract numerical values
with open('Baselight_export.txt', 'r') as fileA:
    baselight = fileA.read()

baseToFix = []
for line in baselight.split('\n'):
    matches = re.findall(r'\d+', line)
    if matches:
        baseToFix.append(matches)

# read in the Xytech.txt file and append numerical values to corresponding lines
with open('Xytech.txt', 'r') as fileB:
    xytech = fileB.readlines()

xyToFix = []
for i in range(len(xytech)):
    if 'production' in xytech[i]:
        for j in range(len(baseToFix)):
            if xytech[i].strip() == baseToFix[j][0]:
                xytech[i] = xytech[i].strip() + ' ' + ' '.join(baseToFix[j][1:]) + '\n'
                xyToFix.append(xytech[i])
                break

# write out results to a csv file
with open('output.csv', 'w', newline='') as fileC:
    writer = csv.writer(fileC)
    writer.writerow(['Xytech Workorder', 'Producer', 'Operator', 'Job', 'Location'])
    for i in range(len(xyToFix)):
        if 'Xytech Workorder' in xyToFix[i]:
            writer.writerow([xyToFix[i].strip(), xyToFix[i+1].strip(), xyToFix[i+2].strip(), xyToFix[i+3].strip(), ''])
        elif 'Location' in xyToFix[i]:
            writer.writerow(['', '', '', '', xyToFix[i].strip()])
        else:
            writer.writerow(['', '', '', '', xyToFix[i].strip()])
