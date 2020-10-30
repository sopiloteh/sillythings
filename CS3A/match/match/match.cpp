/**
 * Original Dating Sim.
 *
 * Copyright (c) 2020, Erick Bravo.
 */

#include "match/match.h"



class Pairing
{
  Match date;
  
};

struct Node
{
  double value;
  Node *next = nullptr;
  Node(double);
};

struct Node *head = NULL;
void insertNode(double n)
{
  struct Node *newNode = new Node;
  newNode->num = n;
  newNode->next = head;
  head = newNode;
}

class List
{
  private:
   Node *_head = nullptr;
   Node *_tail = nullptr;
  
  public:
   bool search(double);
   void pairs();
};

