"""
This starting project is to create a machine learning test enviorment to learn how  I can use differnt models.
its also to see how tensorflow and pickle work, should be fun. Sklearn and numpy are tried and true imports"""



#Load all the required modules.
import tensorflow as tf
import numpy as np
import pickle

# Load all the required modules. This looks like it errors out 
from tensorflow.keras.models import Model  # Fix the typo here
from tensorflow.keras import models  # Fix the typo here
from tensorflow.keras.utils import plot_model
from tensorflow.keras.layers import Input, LSTM, Dense
from sklearn.feature_extraction.text import CountVectorizer 

print(tf.__version__)

#empty strings
input_texts = []
target_texts = []
input_characters = set()
target_characters = set()

# we gotta read the dataset, open the file and see what we have
with open('eng-french.txt','r', encoding='utf-8') as f:
  rows = f.read().split('\n')

#to read the first 10,000 rows and then split the input and target (two columns) by the tabbed space
for row in rows[:10000]:
  #the new variables input_text & target_text are created to allow the splitting of the list
  input_text,target_text = row.split('\t')

  #what this does is add a tab to the variable then on to the next line, sorta like the enter/next cell in excel
  target_text = '\t' + target_text + '\n'
  input_texts.append(input_text.lower())
  target_texts.append(target_text.lower())

  input_characters.update(list(input_text.lower()))
  target_characters.update(list(target_text.lower()))

#now to sort the list by alphabet
input_characters = sorted(list(input_characters))
target_characters = sorted(list(target_characters))

#number length
num_en_chars = len(input_characters)
num_dec_chars = len(target_characters)

#max length of items
max_input_length = max([len(i) for i in input_texts])
max_target_length = max([len(i) for i in target_texts])

print('Number of endcoded chars: ',num_en_chars)
print('Number of decoder chars: ',num_dec_chars)
print('Max input length: ',max_input_length)
print('Max target length: ',max_target_length)

#start of One Hot Encoder process

def bagofcharacters(input_texts,target_texts):
  en_in_data = [] ; dec_in_data = [] ; dec_tr_data = []

  pad_en=[1]+[0] * (len(input_characters) - 1)
  pad_dec=[0] * (len(target_characters)) ; pad_dec[2] = 1

  cv = CountVectorizer(binary=True,tokenizer=lambda txt: txt.split(), stop_words=None, analyzer='char')
  
  for i, (input_t,target_t) in enumerate(zip(input_texts,target_texts)):
    cv_inp = cv.fit(input_characters)
    en_in_data.append(cv_inp.transform(list(input_t)).toarray().tolist())
    cv_tar = cv.fit(target_characters)
    dec_tr_data.append(cv_tar.transform(list(target_t)[1:]).toarray().tolist())
  
  if len(input_t) < max_input_length:
    for _ in range(max_input_length - len(input_t)):
      en_in_data[i].append(pad_en)
  
  if len(target_t) < max_target_length:
    for _ in range(max_target_length - len(target_t)):
      dec_in_data[i].append(pad_dec)

  if (len(target_t) - 1) < max_target_length:
    for _ in range(max_target_length - len(target_t) + 1):
      dec_tr_data[i].append(pad_dec)
  
  if len(input_t) < max_input_length:
    for _ in range(max_input_length - len(input_t)):
      en_in_data[i].append(pad_en)
  
  if len(target_t) < max_target_length:
    for _ in range(max_target_length - len(target_t)):
      dec_in_data[i].append(pad_dec)
  
  if(len(target_t) - 1) < max_target_length:
    for _ in range(max_target_length - len(target_t) + 1):
      dec_tr_data[i].append(pad_dec)
  
  en_in_data = np.array(en_in_data, dtype="float32")
  dec_in_data = np.array(dec_in_data, dtype="float32")
  dec_tr_data = np.array(dec_tr_data, dtype="float32")

  return en_in_data,dec_in_data,dec_tr_data
  

