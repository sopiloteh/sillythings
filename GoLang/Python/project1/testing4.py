import re

# reading in both files
with open('Baselight_export.txt', 'r') as fileA:
    baselight = fileA.read()
with open('Xytech.txt', 'r') as fileB:
    xytech = fileB.read()

# extract numerical values from Baselight_export.txt using regular expressions
numerical_values = re.findall(r'\d+', baselight)

# split Xytech.txt into lines
xytech_lines = xytech.split('\n')

# loop over lines in Xytech.txt and append numerical values from Baselight_export.txt
new_xytech_lines = []
for line in xytech_lines:
    if 'hpsans' in line:  # line contains a file path
        # append numerical values to end of line
        new_line = line.rstrip() + ' ' + ' '.join(numerical_values[:22]) + '\n'
        numerical_values = numerical_values[:]  # remove numerical values that were appended
        new_xytech_lines.append(new_line)
    else:
        new_xytech_lines.append(line)

# join modified lines and write to output file
output = '\n'.join(new_xytech_lines)
with open('output.csv', 'w') as file:
    file.write(output)
