"""
This starting project is to create a machine learning test enviorment to learn how  I can use differnt models.
its also to see how tensorflow and pickle work, should be fun. Sklearn and numpy are tried and true imports"""



#Load all the required modules.
import tensorflow as tf
import numpy as np
import pickle

# Load all the required modules. This looks like it errors out 
from tensorflow.keras.models import Model  # Corrected typo
from tensorflow.keras import models  # Corrected typo
from tensorflow.keras.utils import plot_model
from tensorflow.keras.layers import Input, LSTM, Dense
from sklearn.feature_extraction.text import CountVectorizer


print(tf.__version__)

#empty strings
input_texts = []          #this is the language that we want to read
target_texts = []         #this is the language that we want it to be translated too
input_characters = set()  #to have the alphabet of the input language split out
target_characters = set() #to have the alphabet of the target language split out

# we gotta read the dataset, open the file and see what we have, the encoding tag is due to the french accents
with open('eng-french.txt','r', encoding='utf-8') as f:
  rows = f.read().split('\n')

#to read the first 10,000 rows and then split the input and target (two columns) by the tabbed space
for row in rows[:10000]:
  #the new variables input_text & target_text are created to allow the splitting of the list
  input_text,target_text = row.split('\t')

  #what this does is add a tab to the variable then on to the next line, sorta like the enter/next cell in excel
  target_text = '\t' + target_text + '\n'

  #taking the input and target texts to lowercase and then resubmitting them to the same strings
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
  #starting up some empty lists so as to have the encoded, decoded and translated data
  en_in_data = [] ; dec_in_data = [] ; dec_tr_data = [];

  #this is the start of the Sequance to Sequance model implimentation, pad_en starts with a 1 then adds 0 by the amount of chars
  pad_en=[1]+[0] * (len(input_characters) - 1)
  #this ends the Sequence to Sequence model by ending it with an ending tag with the number of 0's by the char and moves the index to 2
  pad_dec=[0] * (len(target_characters))
  pad_dec[2] = 1

  #this turns each word into a token at each white space, since it is char letters, that is what the vectorizer will focus on
  cv = CountVectorizer(binary=True,tokenizer=lambda txt: txt.split(), stop_words=None, analyzer='char')

  for input_t, target_t in zip(input_texts, target_texts):
    cv_inp = cv.fit(input_characters)
    en_in_data.append(cv_inp.transform(list(input_t)).toarray().tolist())
    cv_tar = cv.fit(target_characters)
    dec_tr_data.append(cv_tar.transform(list(target_t)[1:]).toarray().tolist())

    # Pad or truncate en_in_data[i] to ensure all elements have the same length
    en_in_data[-1] = en_in_data[-1][:max_input_length] + [pad_en] * (max_input_length - len(en_in_data[-1]))

    dec_in_data.append([])

    # Append pad_dec to dec_in_data[i]
    dec_in_data[-1] = dec_in_data[-1][:max_target_length] + [pad_dec] * (max_target_length - len(dec_in_data[-1]))

    # Append pad_dec to dec_tr_data[i]
    dec_tr_data[-1] = dec_tr_data[-1][:max_target_length] + [pad_dec] * (max_target_length - len(dec_tr_data[-1]))
  
  #all the arrays are turned to float32 as to keep proper track of the large amount of 1's & 0's
  en_in_data = np.array(en_in_data, dtype="float32")
  dec_in_data = np.array(dec_in_data, dtype="float32")
  dec_tr_data = np.array(dec_tr_data, dtype="float32")

  return en_in_data,dec_in_data,dec_tr_data
  
  #this is to get the chars to fit in correctly into the CountVectorizer function
"""   for i, (input_t,target_t) in enumerate(zip(input_texts,target_texts)):

    dec_in_data.append([]) # there is an error if you dont initalize the decoded data as 0

    cv_inp = cv.fit(input_characters)
    en_in_data.append(cv_inp.transform(list(input_t)).toarray().tolist())
    cv_tar = cv.fit(target_characters)
  #the decoder target will always start 1 step ahead of the uncoded input
    dec_tr_data.append(cv_tar.transform(list(target_t)[1:]).toarray().tolist())
      #the following if statments are to add either a Sequence to Sequence or Ending to Sequence token to the text
  #this depends on the length of the char 
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
        dec_tr_data[i].append(pad_dec) """
  


#creating an object to hold the total amount of encoded char that this model will use
en_inputs = Input(shape=(None, num_en_chars))

#creating a long short term memeory with 256 dimensions, it will always return true
encoder = LSTM(256, return_state = True)

#discard the encoder output since we only want the actions to save and be stored in the Hidden & Cell state
en_outputs, state_h, state_c = encoder(en_inputs)
en_states = [state_h, state_c]

#creating an object to hold the total amount of decoded char that this model will use
dec_inputs = Input(shape=(None, num_dec_chars))

#creating a long short term memeory with 256 dimensions, it will always return true
dec_lstm = LSTM(256, return_sequences = True, return_state = True)

#now the encoder states that were saved will start up the decoder
dec_outputs, _, _ = dec_lstm(dec_inputs, initial_state=en_states)

#the output layer will have the total number of decoder chars we specified earlier
dec_dense = Dense(num_dec_chars, activation = "softmax")
dec_outputs = dec_dense(dec_outputs)


#with these functions created, there should be enough to now be able to train the model

model = Model([en_inputs, dec_inputs], dec_outputs)

pickle.dump({'input_characters':input_characters, 'target_characters':target_characters, 'max_input_length':max_input_length, 'max_target_length':max_target_length, 'num_en_chars':num_en_chars, 'num_dec_chars':num_dec_chars}, open("training_data.pkl","wb"))

#this loads in the data and tells it to start training
en_in_data, dec_in_data, dec_tr_data = bagofcharacters(input_texts, target_texts)
model.compile(optimizer = "adam", loss="categorical_crossentropy", metrics=["accuracy"])

model.fit(
  [en_in_data, dec_in_data],
  dec_tr_data,
  batch_size= 64,
  epochs = 200,
  validation_split =0.2,
)
#this saves the model in the directory s2s which is outputed as saved_model.pb, this will include the details of the generated model
#the s2s directory is also where the weights from the Seq 2 Seq encoding
model.save("s2s")

model.summary()
plot_model(model, to_file='Model_plot.png', show_shapes=True, show_layer_names=True)



