''''
Erick Bravo
COMP 467
March 14th 2023
Databases
'''

import pymongo

myclient = pymongo.MongoClient("mongodb://localhost:27017/")

'''
mylist = [
  {"name": "John", "address": "Highway 37"},
  {"name:" : "Peter", "address": "Lowstreet 27"},
  { "name": "Amy", "address": "Apple st 652"},
  { "name": "Hannah", "address": "Mountain 21"},
  { "name": "Michael", "address": "Valley 345"},
  { "name": "Sandy", "address": "Ocean blvd 2"},
  { "name": "Betty", "address": "Green Grass 1"},
  { "name": "Richard", "address": "Sky st 331"},
  { "name": "Susan", "address": "One way 98"},
  { "name": "Vicky", "address": "Yellow Garden 2"},
  { "name": "Ben", "address": "Park Lane 38"},
  { "name": "William", "address": "Central st 954"},
  { "name": "Chuck", "address": "Main Road 989"},
  { "name": "Viola", "address": "Sideway 1633"}
]
'''


mylist = []
mydb = myclient["mydatabase"]
mycol = mydb["mycollection"]
dblist = myclient.list_database_names()

if "mydatabase" in dblist:
  print(myclient.list_database_names(),'\n')
  print(mydb.list_collection_names(),'\n')
  
  collist = mydb.list_collection_names()
  if "customers" in collist:
    print("The collection exisits!!\n")

else:
  print('Sorry bucko, ya got nothing!')


