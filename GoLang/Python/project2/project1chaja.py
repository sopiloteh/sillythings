#!/usr/bin/env python
#Place above so you don't have to call python from commandline
import csv

#Open Xytech file
xytech_file_location = "/Users/erickbravo/Downloads/Xytech.txt"
xytech_folders = []

read_xytech_file = open(xytech_file_location, "r")
for line in read_xytech_file:
    if "/" in line:
        xytech_folders.append(line)

#Open Baselight file
baselight_file_location = "/Users/erickbravo/Downloads/Baselight_export.txt"
read_baselight_file = open(baselight_file_location, "r")

#Read each line from Baselight file
for line in read_baselight_file:
    line_parse = line.split(" ")
    current_folder = line_parse.pop(0)
    sub_folder = current_folder.replace("/images1/starwars", "")
    new_location = ""
    #Folder replace check
    for xytech_line in xytech_folders:
        if sub_folder in xytech_line:
            new_location = xytech_line.strip()
    first=""
    pointer=""
    last=""
    for numeral in line_parse:
        #Skip <err> and <null>
        if not numeral.strip().isnumeric():
            continue
        #Assign first number
        if first == "":
            first = int(numeral)
            pointer = first
            continue
        #Keeping to range if succession
        if int(numeral) == (pointer+1):
            pointer = int(numeral)
            continue
        else:
            #Range ends or no sucession, output
            last = pointer
            if first == last:
                print ("%s %s" % (new_location, first))
            else:
                print ("%s %s-%s" % (new_location, first, last))
            first= int(numeral)
            pointer=first
            last=""
    #Working with last number each line 
    last = pointer
    if first != "":
        if first == last:
            print ("%s %s" % (new_location, first))
        else:
            print ("%s %s-%s" % (new_location, first, last))
