''''
Erick Bravo
COMP 467
April 19th 2023
Subprocess
'''

import subprocess
import shlex

# Define the command to be executed
command = 'ls -l /users/erick.bravo'

# Split the command into a list of arguments using shlex
args = shlex.split(command)

# Call the command using subprocess.Popen
process = subprocess.Popen(args, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)

# Initialize variables for the largest file and its size
largest_file = ''
largest_size = 0

# Loop over the output of the command
for line in iter(process.stdout.readline, b''):
    # Decode the line from bytes to string
    line = line.decode('utf-8').strip()

    # Split the line into fields
    fields = line.split()

    # Check if this line corresponds to a file
    if len(fields) >= 8 and fields[0][0] != 'd':
        # Get the file name and size
        file_name = fields[-1]
        file_size = int(fields[7])

        # If this is the largest file so far, update the variables
        if file_size > largest_size:
            largest_file = file_name
            largest_size = file_size

# Print the largest file and its size
print(f'The largest file is {largest_file} with size {largest_size} bytes')
