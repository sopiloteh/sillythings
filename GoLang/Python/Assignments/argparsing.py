''''
Erick Bravo
COMP 467
March 30th 2023
Argparse
'''
import argparse

parser = argparse.ArgumentParser(description='Read a file and optionally print each line.')
parser.add_argument('filename', metavar='filename', type=str, help='path to input file')
parser.add_argument('--verbose', '-v', action='store_true', help='print each line as it is read')
args = parser.parse_args()

with open(args.filename, 'r') as f:
    lines = f.readlines()
    if args.verbose:
        for line in lines:
            print(line.rstrip())
    print(f'Total lines: {len(lines)}')
