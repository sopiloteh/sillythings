""""
just a small info block on some python learning
"""

import math
import random

rangeA = int(input("Please choose a starting number: "))
rangeB = int(input("Please choose an ending number: "))
rangeC = rangeA - rangeB

print('\nWelcome to the number guessing game, please select a range of numbers')
print('This is your range that your magic number will be picked from:', rangeA, '-', rangeB)

if rangeA < rangeB:
  print('Sorry! A has to be larger then B, try again!!')
  exit()
else:
  print('Ok your numbers passed, lets go!\n\n')

print('something ',rangeC)

"""
integers are ints 1
floating points are float 1.2345
strings are str "we are writing a sentance"
lists are list [a, b, c, d, e, f]
Dictonaries are dict which are paired values [a:1, b:2, c:3,d:4]
Tupples are tup which are ordered sequences? [10, "hello", 10.21] so int str then float
sets are set which are unique collections [a,b,c,d] think like prime nnumbers or alphabet
booleans are bool which are logic
"""

adding = 2+1
subbing = 2-1
dividing = 3/2

print('now lets show modulus\n')
divA = 7/4
divB = 7%4

print('some other math functions\n')
divC = 20%2
expo = 2**3
orderA = 2+10*10+3
orderB = (2+10)*(10+3)

"""
indexing starts at 0 when you have items in a list
string h e l l o
indexing 0 1 2 3 4
rev index 0 -4 -3 -2 -1

slicing means where you want to grab something out of the string perhaps
start stop step, when you begin, when you end and how big of a jump

make sure to be careful when using single, double triple qutoes 

when wanting to find a location of a char in a string you can do 
word[0] where the number is the location of the string using regular indexing or reverese indexing

storing words as a variable like so
"""

name = "sam"
last_letters = name[1:]
#this will output anything after the spot 1, you can then then add it like so
'P'+last_letters 
#this will show "pam"

