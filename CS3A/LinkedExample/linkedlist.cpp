#include <iostream>


class Node
{
public:
  int key;
  int data;
  Node *next;			// pointer to point at next node

    Node ()			// constructor for node
  {
    key = 0;
    data = 0;
    next = NULL;
  }

  Node (int k, int d)		// takes input and converts it into accessable data by class
  {
    key = k;
    data = d;
  }
};

class SinglyLinkedList
{
public:
  Node * head;

  SinglyLinkedList ()		// constructor for the node
  {
    head = NULL;
  }

  SinglyLinkedList (Node * n)	// constructor to pass by reference variable
  {
    head = n;
  }

  // checking if node exisits using key value
  Node *nodeExists (int k)	// method to check if variable k is used already, returns pointer
  {
    Node *temp = NULL;
    // this is a local pointer that looks at head and then allows var temp to look over
    Node *ptr = head;
    while (ptr != NULL)
      {
	if (ptr->key == k)
	  {
	    temp = ptr;
	  }
	ptr = ptr->next;
      }
    return temp;
  }

  // this will always ADD at the end of the list
  void appendNode (Node * n)
  {
    if (nodeExists (n->key) != NULL)
      {
	std::cout << "Node exists " << n->key << "add another one\n";
      }
    else
      {
	if (head == NULL)
	  {
	    head = n;
	    std::cout << "Node added\n";
	  }
	else
	  {
	    Node *ptr = head;
	    while (ptr->next != NULL)
	      {
            ptr = ptr->next;
	      }
          ptr->next = n;
          std::cout << "Node added\n";
	  }
      }
  }

  void prependNode(Node* n)
  {
    if (nodeExists (n->key) != NULL)
      {
	std::cout << "Node exists " << n->key << "add another one\n";
      }
    else
      {
        n->next = head;
        head = n;
        std::cout << "code appended\n";
      }     
  }

  // this allows the node to be inserted after a specific node
  void insertNodeAfter(int k, Node *n)
  {
   Node* ptr = nodeExists(k);
   if(ptr == NULL)
   {
     std::cout << "no node exists with value "<< k <<" \n";
   }
   else
   {
    if (nodeExists (n->key) != NULL)
      {
	std::cout << "Node exists " << n->key << "add another one\n";
      }
    else
    {
      n->next = ptr->next;
      ptr->next = n;
      std::cout << "Node inserted\n";
    }
   } 
  }

  // deletes the node by selecting a value or K
  void deleteNodeByKey(int k)
  {
    if (head == NULL)
    {
      std::cout << "Singly linked list already empty, cant delete\n";
    }
    else if (head != NULL)
    {
        if (head->key == k)
        {
          head = head->next;
          std::cout << "Node unlinked with keys value : " << k << "\n";
        }
        else
        {
          Node* temp = NULL;
          Node* prevptr = head;
          Node* currentptr = head->next;
          while(currentptr != NULL)
          {
            if (currentptr->key == k)
            {
              temp = currentptr;
              currentptr = NULL;
            }
            else
            {
              prevptr = prevptr->next;
              currentptr = currentptr->next;
            }            
          }

          if (temp != NULL)
          {
            prevptr->next = temp->next;
            std::cout << "Node unlinked with keys values: " << k << "\n";
          }
          else
          {
            std::cout << "Node dosent exist with keys values: " << k << "\n";
          }
        }        
    }
  }

  void updateNodeByKey(int k, int d)
  {
    Node* ptr = nodeExists(k);
    if (ptr != NULL)
    {
      ptr->data = d;
      std::cout <<"Node data updated\n";
    }
    else
    {
      std::cout<<"Node dosent exisit with key value : " << k <<"\n";
    }
    


  }

  void printList()
  {
    if (head == NULL)
    {
      std::cout << "No nodes in list\n";
    }

    else
    {
      std::cout << "\n singly linked list values : ";
      Node* temp = head;

        while(temp != NULL)
        {
          std::cout << "("<< temp->key << ","<< temp->data <<") -->";
          temp = temp->next;
        }
    }
  }
};

int main ()
{
  SinglyLinkedList s;
  int option;
  int key1, k1, data1;
  
  do
  {
    std::cout<<"What opeation do you want to preform?\nEnter 0 to exit\n";
    std::cout<<"1. append\n2. prepend\n3. insert after\n4. delete node\n5. update node\n6. print\n7. clear screen\n\n";

    std::cin >> option;
    Node* n1 = new Node();

    switch(option)
    {
        case 0:
          break;
        case 1:
          std::cout<<"append node \nEnter key and data to be appended\n";
          std::cin>>key1;
          std::cin>>data1;
          n1->key =  key1;
          n1->data = data1;
          s.appendNode(n1);
          break;
        case 2:
        // hakata kosha, nagomi cake house, ise shima
          std::cout<<"prepend node operation \nEnter key and data of the node to prepend\n";
          std::cin>>key1;
          std::cin>>data1;
          n1->data = data1;
          s.prependNode(n1);
          break;
        case 3:
          std::cout<<"insert node after operation\nEnter key of exisitng node after you want to insert: \n";
          std::cin >> k1;
          std::cout<<"Enter key and data of the new node first\n";
          std::cin>>key1;
          std::cin>>data1;
          n1->key = key1;
          n1->data=data1;
          s.insertNodeAfter(k1,n1);
          break;
        case 4:
          std::cout<<"delete node by key operation\nEnter the key of the node to delete: \n";
          std::cin>>k1;
          s.deleteNodeByKey(k1);
          break;
        case 5:
          std::cout<<"Update node by key operation\nEnter key and new data to be updated\n";
          std::cin>>key1;
          std::cin>>data1;
          s.updateNodeByKey(key1,data1);
          break;
        case 6:
          s.printList();
          break;
        case 7:
          system("cls");
          break;
        default:
          std::cout<<"Enter proper option plz \n";
    }
  }

  while(option != 0);
  return 0;
}