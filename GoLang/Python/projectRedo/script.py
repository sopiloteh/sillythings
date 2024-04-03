"""
Erick Bravo
Project Script Redo
December 15th 2023
"""

import argparse
import xlsxwriter


"""Variables"""

baseFile = "Baselight_export.txt"                     #file location for this, however need to change it so that its argparse
readBaseFile = open(baseFile,"r")                     #reading file to be used

xyzFile = "Xytech.txt"                                #file location for this file, need to make it argparseable
readXyzFile = open(xyzFile, "r")                      #reading file to be used
xyzStorage = []

for line in readXyzFile:
  if "/" in line:
    xyzStorage.append(line)

print('Python Script to filter frames:')

"""***********************************************************************"""

