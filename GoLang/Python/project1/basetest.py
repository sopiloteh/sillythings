import re

# read the text file
with open('Baselight_export.txt', 'r') as fileA:
    baselight = fileA.read()

sentances = re.split('[.!?\n]', baselight)

data_into_list = baselight.split("\n")


for phrase in data_into_list:
    print(phrase.strip())
    print()

print('\n\nthis is us\n\n')

def extractStuff(data_into_list):
    res = []
    for el in data_into_list:
        sub = el.split('\n')
        res.append(sub)
    return(res)

print(extractStuff(data_into_list))

