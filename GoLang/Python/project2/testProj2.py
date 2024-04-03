''''
Erick Bravo
COMP 467
April 11th 2023
Project 2
'''
import argparse
import csv
import pymongo

parser = argparse.ArgumentParser(description='Process Baselight/Flames and Xytech text files')
parser.add_argument('baselight_file_location', type=str, help='Path to the Baselight/Flames text file')
parser.add_argument('xytech_file_location', type=str, help='Path to the Xytech text file')
parser.add_argument('--verbose', action='store_true', help='Print output to console')
parser.add_argument('--output', choices=['csv', 'database'], default='csv', help='Output to CSV or database')

args = parser.parse_args()

xytech_file_location = args.xytech_file_location
baselight_file_location = args.baselight_file_location

xytech_folders = []

read_xytech_file = open(xytech_file_location, "r")
colorist_line = None

for line in read_xytech_file:
    if "/" in line:
        xytech_folders.append(line)
    if "colorist" in line:
        colorist_line = line.strip()
        break
    if colorist_line is not None:
      # Get the word after "colorist"
        words = colorist_line.split()
        index = words.index("colorist")
        user_on_file = words[index+1]
    else:
    # Set a default value for user_on_file
        user_on_file = "unknown"



read_xytech_file.close()
read_baselight_file = open(baselight_file_location, "r")

myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mylist =[]


if args.output == 'csv':
    csv_file = open('output.csv', 'w')
    csv_writer = csv.writer(csv_file)
    csv_writer.writerow(['Location', 'Range', 'UserOnFile'])

elif args.output == 'database':
    mydb = myclient["mydb"]
    mycol = mydb["mycol"]
    for line in read_baselight_file:
        line_parse = line.split(" ")
        current_folder = line_parse.pop(0)
        sub_folder = current_folder.replace("/images1/", "").replace("/net/flame-archive Avatar/", "")
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
            else:
                #Range ends or no sucession, output
                last = pointer
                if args.verbose:
                    if first == last:
                        print ("%s %s" % (new_location, first))
                    else:
                        print ("%s %s-%s" % (new_location, first, last))
                doc = {"Location": new_location, "Range": str(first) + '-' + str(last) if first != last else str(first),"UserOnFile": user_on_file}
                mylist.append(doc)
                first= int(numeral)
                pointer=first
                last=""
        #Working with last number each line 
        last = pointer
        if first != "":
            if args.verbose:
                if first == last:
                    print ("%s %s" % (new_location, first))
                else:
                    print ("%s %s-%s" % (new_location, first, last))
            doc = {"Location": new_location, "Range": str(first) + '-' + str(last) if first != last else str(first),"UserOnFile": user_on_file}
            mylist.append(doc)
    #Insert documents into the collection
    mycol.insert_many(mylist)


for line in read_baselight_file:
    line_parse = line.split(" ")
    current_folder = line_parse.pop(0)
    sub_folder = current_folder.replace("/images1/", "").replace("/net/flame-archive Avatar/", "")
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

        #Keeping to range if succession
        if int(numeral) == (pointer+1):
            pointer = int(numeral)
            continue
        else:
            #Range ends or no sucession, output
            last = pointer
            if args.verbose:
                if first == last:
                    print ("%s %s" % (new_location, first))
                else:
                    print ("%s %s-%s" % (new_location, first, last))
            if args.output == 'csv':
                if first == last:
                    csv_writer.writerow([new_location, str(first)])
                else:
                    csv_writer.writerow([new_location, str(first) + '-' + str(last)])
            else:
                pass
            first= int(numeral)
            pointer=first
            last=""
    #Working with last number each line 
    last = pointer
    if first != "":
        if args.verbose:
            if first == last:
                print ("%s %s" % (new_location, first))
            else:
                print ("%s %s-%s" % (new_location, first, last))
        if args.output == 'csv':
            if first == last:
                csv_writer.writerow([new_location, str(first)])
            else:
                csv_writer.writerow([new_location, str(first) + '-' + str(last)])
        else:
            pass

read_baselight_file.close()

if args.output == 'csv':
    csv_file.close()
