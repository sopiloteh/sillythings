''''
Erick Bravo
COMP 467
April 29th 2023
Project 3
''' 
import pymongo
import argparse
import datetime
import os
import csv
import subprocess



#how to run:
# general python3 proj3.py twitch_nft_demo.mp4 --output my_results.csv
# mac python3 proj3.py /Users/erickbravo/Desktop/twitch_nft_demo.mp4 --output my_results.csv
# win python3 proj3.py twitch_nft_demo.mp4 --output my_results.csv



parser = argparse.ArgumentParser(description='Read a file')
parser.add_argument('video', metavar='video', type=str, help='path to input file')
parser.add_argument('--output', metavar='output', type=str, help='path to output CSV file')
args = parser.parse_args()

media_info = args.video
video_path = media_info

myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["mydb"]
mycol = mydb["mycol"]

# Retrieve all documents from the collection
documents = mycol.find()


#----------------look at mongodb for proj results and turn it into timecode
# Create an empty list to store the numbers
range_list = []

# Extract and add numbers from the "Range" field to the list
for document in documents:
    range_value = document["Range"]
    if "-" in range_value:
        start, end = map(int, range_value.split("-"))
        for number in range(start, end + 1):
            range_list.append(number)
    else:
        range_list.append(int(range_value))

# Print the list of numbers
range_list.sort()
#print(range_list)

# Create an empty list to store the timecodes
timecode_list = []

# Transform numbers into timecode format
for number in range_list:
    timecode = str(datetime.timedelta(seconds=number))
    timecode_list.append(timecode)


#----------------import videdo for timecode conversion and comparison
input_video = "twitch_nft_demo.mp4"
output_filename = "output_with_timecode.mp4"
output_video = os.path.join(os.path.dirname(input_video), output_filename)

command = f'ffmpeg -i {input_video} -vf "drawtext=fontfile=/path/to/font.ttf: text=\'%{{pts\\\\:hms}}\': x=(w-tw)/2: y=h-(2*lh): fontcolor=white: fontsize=24: box=1: boxcolor=0x00000000@1" -c:a copy {output_video}'

subprocess.call(command, shell=True)

# Retrieve the timecodes and store them in a list
timecodeA = []
ffmpeg_output = subprocess.check_output('ffprobe -show_entries frame=coded_picture_number -of csv=p=0 -v quiet {}'.format(output_video), shell=True, universal_newlines=True)
lines = ffmpeg_output.strip().split('\n')
for line in lines[1:]:
    frame_number = line.strip()
    if frame_number != '':
        timecodeA.append(int(frame_number))

# Sort the timecodes in sequential order
timecodeA.sort()


#----------------timecode conversion and comparison
# Convert the marks in timecodeA to H:MM:SS format
timecodeB = [f'{mark // 3600}:{(mark // 60) % 60:02}:{mark % 60:02}' for mark in timecodeA]

# Compare timecode_list and timecodeB to find the matching numbers
timecodeC = [timecode for timecode in timecode_list if timecode in timecodeB]

# Print timecodeC
#print("timecodeC:", timecodeC)

#----------------timecode conversion and comparison
print("Frames exporting starting now\n")
output_directory = "frames"
os.makedirs(output_directory, exist_ok=True)

# Export frames as PNG files
for index, timecode in enumerate(timecodeC):
    frame_output_path = os.path.join(output_directory, f"frame_{index}.png")
    ffmpeg_cmd = f"ffmpeg -ss {timecode} -i {output_video} -frames:v 1 -q:v 1 {frame_output_path}"
    subprocess.call(ffmpeg_cmd, shell=True)


print("Frames exported successfully.")

#----------------csv file output

csv_file = args.output
# Create the legend
legend = "-------Project3-------\n" \
         "project2 results: timecode_list\n" \
         "twitch video: timecodeB\n" \
         "matching times: timecodeC\n" \
         "-------------------------\n"

with open(csv_file, 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow([legend])  # Write the legend as a single-cell row
    writer.writerow([])  # Write an empty row
    writer.writerow(["timecode_list", "timecodeB", "timecodeC"])  # Write header row
    writer.writerows(zip(timecode_list, timecodeB, timecodeC))


print("org time code:\n",timecode_list,'\n\n\n')
print("timecodeB:\n", timecodeB,'\n\n\n')
print("timecodeC:\n", timecodeC,'\n\n\n')