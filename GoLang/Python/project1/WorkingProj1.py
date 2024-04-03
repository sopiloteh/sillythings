""" 
Erick Bravo
Febuary 23rd 2023
COMP 467 Parsing
Project 1
"""


import re
import csv

# Define regular expressions to match file paths and frame numbers
path_regex = r"/\w+/[\w/]+/\d+x\d+"
frame_regex = r"\d+"

# Define a function to extract file paths and frame numbers from a string
def extract_frames(input_string):
    # Find all file paths in the input string
    paths = re.findall(path_regex, input_string)
    frames = []
    # Find all frame numbers in the input string
    for path in paths:
        frames_str = re.findall(frame_regex, input_string[input_string.find(path)+len(path)+1:])
        # Convert frame numbers from strings to integers
        frames_int = [int(frame) for frame in frames_str]
        frames.append((path, frames_int))
    return frames

# Read the data from the baselight_export.txt file
with open('baselight_export.txt', 'r') as f:
    data = f.read()

# Extract file paths and frame numbers from the data
frames = extract_frames(data)

# Read the data from the Xytech.txt file
with open('Xytech.txt', 'r') as f:
    data = f.read()

# Find the show location and notes in the Xytech.txt data
show_location = re.findall(path_regex, data)[0]
notes = re.findall(r"Notes:\n(.*)", data, re.DOTALL)[0].strip()

# Group frames by file path
frames_by_path = {}
for path, frame_numbers in frames:
    if path in frames_by_path:
        frames_by_path[path].extend(frame_numbers)
    else:
        frames_by_path[path] = frame_numbers

# Sort frame numbers and group them into ranges
for path in frames_by_path:
    frames_by_path[path] = sorted(list(set(frames_by_path[path])))
    ranges = []
    start = end = frames_by_path[path][0]
    for frame in frames_by_path[path][1:]:
        if frame == end + 1:
            end = frame
        else:
            ranges.append((start, end))
            start = end = frame
    ranges.append((start, end))
    frames_by_path[path] = ranges

# Write the result to a CSV file
with open('result.csv', 'w', newline='') as f:
    writer = csv.writer(f)
    # Write the first line with producer, operator, job, and notes
    writer.writerow(['Producer', 'Operator', 'Job', 'Notes'])
    writer.writerow(['Joan Jett', 'John Doe', 'Dirtfixing', notes])
    writer.writerow([])
    # Write the fourth line with show location and frames to fix
    writer.writerow(['Show Location', 'Frames to Fix'])
    for path in frames_by_path:
        for start, end in frames_by_path[path]:
            writer.writerow([show_location, f"{path} ({start} {'-' if end > start else ''} {end})"])
