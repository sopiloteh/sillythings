''''
Erick Bravo
COMP 467
March April 26th 2023
ffmpeg
'''

import subprocess

media_info = "/Users/erickbravo/Desktop/waterfall.mov"

# Set the FFmpeg commands to execute
ffmpeg_cmdA = ["ffmpeg", "-i", media_info, "-vf", "scale=640:480", "-c:a", "copy", "output.mp4"]
ffmpeg_cmdB = ["ffmpeg", "-i", media_info, "-ss", "00:00:05", "-vframes", "1", "frame.png"]
ffmpeg_cmdC = ["ffmpeg", "-i", media_info, "-filter_complex", "[0:v] fps=10, scale=320:-1, split [a][b];[a] palettegen [p];[b][p] paletteuse", "output.gif"]

# Run the FFmpeg commands using subprocess
subprocess.call(ffmpeg_cmdA)
subprocess.call(ffmpeg_cmdB)
subprocess.call(ffmpeg_cmdC)