''''
Erick Bravo
COMP 467
April 11th 2023
Timecode
'''

def frame_to_timecode(frame):
    seconds = frame // 24
    minutes = seconds // 60
    hours = minutes // 60
    
    frame %= 24
    seconds %= 60
    minutes %= 60
    
    return f"{hours:02d}:{minutes:02d}:{seconds:02d}:{frame:02d}"

# Example usage:
frames = [35, 1569, 14000]
for frame in frames:
    timecode = frame_to_timecode(frame)
    print(f"Frame {frame} is {timecode}")

print('Magneto did nothing wrong')
