''''
Erick Bravo
COMP 467
March 9th 2023
Spacing
'''

# Read file
with open('lesson4_folderexample.txt', 'r') as f:
    folders = f.readlines()

fixed_folders = []
for folder in folders:
    folder = folder.strip()  # Remove new line character
    if ' ' in folder:
        fixed_folder = folder.replace(' ', '')  # Remove spaces
        fixed_folders.append(fixed_folder)
        print(f'{folder} --> {fixed_folder} (needed fixing)')
    else:
        fixed_folders.append(folder)
        print(f'{folder} (fine)')

