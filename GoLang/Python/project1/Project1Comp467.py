""" 
Erick Bravo
Febuary 23rd 2023
COMP 467 Parsing
Project 1
"""
import re

#reading in both files
with open('Baselight_export.txt', 'r') as fileA:
    baselight = fileA.read()
with open('Xytech.txt', 'r') as fileB:
    xytech = fileB.read()

baseToFix = []
xyToFix = []


#cut them out
sentances = re.split('[.!?\n]', baselight)

#finding the phrases that are specified in xytech
phrasesA = [phrase for phrase in sentances if re.search('/images1/starwars/reel1/partA/1920x1080', phrase)]
phrasesB = [phrase for phrase in sentances if re.search('/images1/starwars/reel1/VFX/Hydraulx', phrase)]
phrasesC = [phrase for phrase in sentances if re.search('/images1/starwars/reel1/VFX/Framestore', phrase)]
phrasesD = [phrase for phrase in sentances if re.search('/images1/starwars/reel1/VFX/AnimalLogic', phrase)]
phrasesE = [phrase for phrase in sentances if re.search('/images1/starwars/reel1/partB/1920x1080', phrase)]
phrasesF = [phrase for phrase in sentances if re.search('/images1/starwars/pickups/shot_1ab/1920x1080', phrase)]


#printing these out as a test for project
print('\n Errors in baselight \n')
for phrase in phrasesA + phrasesB + phrasesC + phrasesD + phrasesE + phrasesF:
    print(phrase.strip())
    print()

sentancesB = re.split('[.!?\n]', xytech)

#finding the phrases that are specified in xytech
orderA = [phrase for phrase in sentancesB if re.search('/hpsans13/production/starwars/reel1/partA/1920x1080', phrase)]
orderB = [phrase for phrase in sentancesB if re.search('/hpsans12/production/starwars/reel1/VFX/Hydraulx', phrase)]
orderC = [phrase for phrase in sentancesB if re.search('/hpsans13/production/starwars/reel1/VFX/Framestore', phrase)]
orderD = [phrase for phrase in sentancesB if re.search('/hpsans14/production/starwars/reel1/VFX/AnimalLogic', phrase)]
orderE = [phrase for phrase in sentancesB if re.search('/hpsans13/production/starwars/reel1/partB/1920x1080', phrase)]
orderF = [phrase for phrase in sentancesB if re.search('/hpsans15/production/starwars/pickups/shot_1ab/1920x1080', phrase)]


print('\n Orders from Xytech \n')
for phrase in orderA + orderB + orderC + orderD + orderE + orderF:
    print(phrase.strip())
    print()

"""
print('\n\n\n\n\n')

# remove sequential numbers from phrasesA
new_phrasesA = []
for phrase in phrasesA + phrasesB + phrasesC + phrasesD + phrasesE + phrasesF:
    # match sequential numbers at the beginning of the phrase
    match = re.match(r'^\d+\.\s', phrase)
    if match:
        # remove sequential numbers and append the modified phrase to the new list
        new_phrasesA.append(re.sub(r'^\d+\.\s', '', phrase))
    else:
        new_phrasesA.append(phrase)

print('\n did this print out\n')
# printing modified phrasesA
for phrase in new_phrasesA:
    print(phrase.strip())
    print()
"""

