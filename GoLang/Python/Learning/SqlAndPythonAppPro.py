"""process block:
this is part of a flowchart diagram that uses a rectangle shape to
capture processing steps like a basic task(toggling a radio button or checking yes etc) in the process""" 

"""Decision Block:
a boolean for a flowchart, this is shaped as a diamond so the user can see where to go if its a yes or a no
usually only two choices are there with them being yes or no as a singular output
"""

"""stored data block:
this is a flowchart icon thats normally showen as a memory card, this is where the general storage data is stored
it is not tied to any storage media so the user doesnt assume it can only be a certain type"""

"""data block i/o:
this is a shape that looks like a parallelogram to show input and output from a process
think of it as a functioninal one way street
"""

"""terminal/terminator:
this in flowchart parlance tells the user that this is where it all ends or starts, most often times the shape
will have some text inside it denoting which of the two. Its pill shaped"""

"""Document:
denoted as an upside down wave, this shows documentation  as represented inside a flowchart
conssider it an endpoint"""

"""direct data:
displayed as a cylinder, this is a process flow of information as it goes into the computers hard drive
usually its shown as cylinder upright or a cone on its side. the data inside this can be accessed by the user
"""

"""internal storage:
this is a storage feature where it is directly stored inside the computer itself thats stored on memory
early versions of this was called magnetic memory which can is now reffered to random access memeory or ram """

"""sequential access:
this is  for a tape drive, essentaially storage, you have to keep scrolling until you find it. Since it is
a tape drive, the icon has a little tag at the bottom. Its a giant Q"""

"""manual input:
displayed as a ramp with a slight slope from left to right, this is a users i/o however this information
might come in as a string only and have to be manually inputted"""

"""subroutine:
this is usually a task that waits for a master task to run first before it can be enabled. the originating task
has to be created first before any subroutine can be created
for flowchart schematics, its showen as rectangle with two vertical columns"""

"""sequence programming:
basically coding from the top down, any actions you start on top will cascade to the bottom. Nothing will be skipped
"""

"""selection programming:
this a fancy way of saying If/Else statements. The user must select an action before continuing.
either of these actions have thier own subroutine to follow before it returns to the main program
"""

"""loop:
this type of programming requires a certain condition to be met before the actions can be moved forward
usually inside these loops there is a subroutine that runs. a cautionary tale of loops is if they are not 
programmed correctly then it will run infintenly causing a program crash
"""

"""iteration: this is a single passthru inside the loop, it is self containted and will not interact with
anything outside of the loop, it will only give a result. this result can then be used outside for X purpose"""

"""encapsulation: this method of programming writes code in a manner that an end programmer can use parts of a program
without having to use the whole part, this is usually achived by hiding parts of the program by permissions or design
in java, c++ this is used as Object oriented programming with classes, to call the hideen encapsualted part of the code
you create a method that is an alias for whatever youre going to do"""

"""abstraction: this goes hand in hand with encapsulation, when a method is created, that is the public way to get the private code 
this will usually have a helper function in case any  requirements on usage are needed for the method"""

"""inhertiance: like the name implies, classes that are created and have public methods can allow these to be  used in other areas.
they can share attributes and methods. This makes it easier to write code for bigger progjects or see where a bug is. Beacuse it is gaining it
from another class, the originating class is called the parent and any sub classes are called child. When a child uses any inherited method
they can give it another skin"""

"""polymorphisim: another OOP idea, this says that many objects can access data in the same interface with their own reskinning
this is the overall arching idea with abstraction, encapsulation and inheritance"""

"""SDLC Analysis: this is how user requirements are determinted. Models are created with graphics to display how each of these models will interact with the main system
ALong with this are relationships created, activites, all outcomes and outputs that may occur. In essence this is a data gathering fact finding mission
with all involved stakeholders to garner the best way to approach the problem or goal """

"""SDLC: planning:
once the analysis phase is finished, a determination is needed to be done for the resources to implement the idea, how much manpower will be requeired and if any
subgoals need to be run in concurrance with the main project. By the end of this phase, the feasability of the project before any serious work should be seen."""

"""SDLC: Design:
this phase allows the main structure of the goal to be fleshed out first logically then physically
All stakeholders get a final overview and allowed review to fine tune the result. This stage is often seen as critical
as any missed opninons/reviews or notes could wind up costing more in the end in redos, cost overruns or delays"""

"""SDLC: Development Phase:
takes all the data from planning, design and analysis and then startrs to actually create somethign
this is where the heavy lifiting is done with whatever code methodology (waterfall, agile, scrum) the team decides one
This is where code style and best practices shine"""

"""SDLC: Testing: 
after a good chunk or checkpoint is reached in the code writing, it needs to be tested before more code is written
unit tests are created for sections of written code and then seen where the defects or bugs are, any mistakes cauyght now will allow the team to
save valuble time later from debugging the code or preventing extra useless code fromm being written"""

"""SDLC: Deployment: 
at this phase a working protoype will be functional, not all the goals from the design phase will be met but will be added
to the development phase workload. User input is again allowed to come to see what the first thoughts are
usually this can create new ideas that can be run back up the chain or a tempering of expectations"""

"""Data Structure Graph:
this can be an organized set of data that connects, each point of data is called a node, a connection is called the vertix
and the connectiors are called edges. Many diffrent types of data strucutres use graphs"""

"""Directed Graph:
this is a type of data display structure that has a direction added to it, think of it as a vector, plane A is going to Dest B
another example is user A follows User B but User B does not follow back"""

"""Binary Tree:
this is a type of data structure that has a top node, this top one is considered the root with and following nodes 
being considered the child nodes, at most only two child nodes can be attached to any root nodes. There can be nodes
without children nodes, these are called leaves. The height of the Binary tree is depenedent on the distance from root node to leaf""""

"""Full Binary Tree: 
just like a binary tree but only that every single node is filled out to max or none at all, that is to say either at 0 or at 2"""

"""Perfect binary Tree:
just like a binary tree but only that every interior node is filled, nothing is empty
for outside nodes that are leaves, they are all at the bottom"""

"""queue data strucures:
this type of data hording is where all your points opperate on a First In First Out basis
this is a Line example, you want to ride the roller coaster, so you make a queue/line to get on it. People who arrived there first
are able to board it and remove themselves from the top of the queue, then the next in line moves forward becoming the head
to load a data point is to enqueue, to remove a data point is to dequeue"""

"""hash table:
a hash table has all the data unsorted laying on a stack, this is all numerized with a top down numbering which acts as a key
finding data is as simple as providing the key to the table so it can access right away, however this can be horribly slow since the data is not sorted at all
this unsortedness means there will be some delays """

"""linked list:
a list where each data point is held together as in a chain, this means the data is read sequentially. You cant jump to a point in the list, you must go thru its entirety"""

"""Stack Data Structure:
this is a Last In First out approach, think of it as a pile of books you want to read. You lay them on the floor in a pile and once you
finish a current book you toss it and grab the next from the pile, any additional items get added  either will be accessed or buired in the stack till it is called up
to add items it is push, to take items off it is pop"""

"""scalar multiplication:
 this is matrices, linear algebra. Multiplying a real number by an array of numbers"""

"""addition of matricies:
you can two matrices of same size together """

"""matrix multiplication:
you can multiply two matricies as long as they have the same rows equal to columns,
you multiply by first getting an element from colA and RowB

|1 2 3| * |1| = 1*1 + 2*2 + 3*3 = 1+4+9n =  |14|
|4 5 6|   |2| = 4*1 + 5*2 + 6*3 = 4+10+18 = |32|
          |3|

"""

"""Matrix Transpose:
this just means that a matrix is flipped on a corner, for example we have an array like this
rows become columns and columns become rows
|1 2 3|  = |1 4|
|4 5 6|    |2 5|
           |3 6|
"""

"""gap buffer:
a dynamic array that allows i/o at a pointed location
the data has to be clusterd closely in order to be efficent, otherwise time is wasted searching
"""

"""Heap Binary Tree:
this is a binary tree that has two additional items added to it. Its shap as well as heap property??
Apprently heap property means max min, need to look up"""

"""AVL tree:
a self balencing binary tree, this will move child nodes down until all sublebvels are within range of each other
when the tree balences, these are called rotations"""

"""Decsion tree:
this type of tree only has three types of nodes. They are decision, chance and end. They dont leave much up to the user or data so
mostly used for already sorted items"""

"""red black tree:
self balenced binary tree in which the nodes have color added to them. Be it red or black, for the most part all parts of the tree are
black with new inserts into the tree marked as red. This type of tree is also self balencing. Mostly used for SQL type of data structures
since its time to recompile is shorter then AVL trees"""

"""SQL Distinct:
used along with the command Select to find all unique records only"""

"""SQL Limit: this command finds a subset of records that corrispond to a condition"""

"""FQL:
Fully Qualified Names these are names that specify an object in the sql server. It allows you to call from a database to a schema and so on """

"""SQL Where:
this command is used to pull out a specific record that meets the condition"""

"""SQL Like:
this command spcifeys items for your Where command search, its an additional filter basically"""

"""SQL Custom Names:
this allows you to change the Fully qullified names to shorthand, think of this as abstraction but for SQL renaming a method """

"""Inner join:
this type of SQL merging is where the rows are merged together but only when the records match on both sides"""

"""Left Outer Join:
an sql join where everything on the left side merges with the table, no rows have to match at all

heres some example code:
SELECT <pick list>
FROM tableA A          <- data
LEFT JOIN tableB B     <- mergie
ON A.Key = B.Key       <- merging the keys
"""

"""Right Outer Join:
everything joins from the right side, nothing has to match

SELECT <pick list>
FROM tableA A          <- data
RIGHT JOIN tableB B     <- mergie
ON A.Key = B.Key       <- merging the keys
"""

"""Full Outer Join: 
this merges everything all at once from both sides
SELECT <pick list>
FROM tableA A          <- data
FULL OUTER JOIN tableB B     <- mergie
ON A.Key = B.Key       <- merging the keys
"""

"""Inner Join:
this only merges the matching rows from both sets
SELECT <pick list>
FROM tableA A          <- data
INNER JOIN tableB B     <- mergie
ON A.Key = B.Key       <- merging the keys
"""

"""Full Outer Join with Null:
this merges everything but only one indexing key is used from the two merged tables
SELECT <pick list>
FROM tableA A          <- data
FULL OUTER JOIN tableB B     <- mergie
ON A.Key = B.Key       <- merging the keys
WHERE: A.Key is NULL
OR B.Key IS NULL <- this picks only onee
"""

"""Right Join with Null:
same as a regular right join but only that it excludes the merged index key
SELECT <pick list>
FROM tableA A          <- data
RIGHT JOIN tableB B     <- mergie
ON A.Key = B.Key       <- merging the keys
WHERE A.Key is NULL    <- this only picks the merged key
"""

"""Left Join with Null:
same as a regular left join but only that it excludes the merged index key
SELECT <pick list>
FROM tableA A          <- data
LEFT JOIN tableB B     <- mergie
ON A.Key = B.Key       <- merging the keys
WHERE B.Key is NULL    <- this only picks the merged key
"""

"""SQL Union:
this search filter allows you to find statements in your search without any repeats
"""

"""SQL Union ALL:
what this does is allow you to chain together multiple union statements but this will also allow all the duplicates to show
"""

"""ALTER TABLE:
This SQL command allows you to make changes to the data holding table, often it has ALter ADD Column or ALter Modify columnns
this is in case you need to add a new catagory or change the name of it
"""

"""SQL DROP:
This command should be used with caution as it will erase all data on the object"""

"""SQL View:
this SQL command allows the user to view a query """


