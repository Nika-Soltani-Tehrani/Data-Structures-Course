#include <inttypes.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>



struct Node {
	int data;
	struct Node* nxp;
	struct Node* tail;
};

struct Node* XOR(struct Node* a, struct Node* b)
{
	return (struct Node*)((uintptr_t)(a) ^ (uintptr_t)(b));
}

// Function to insert a node with given value at given position
struct Node* insert(struct Node** head, int value, int position)
{
    // If XOR linked list is empty
    if (*head == NULL) {

        if (position == 1) {

            struct Node* node = (struct Node*)malloc(sizeof(struct Node));
            node->data = value;
            node->nxp = XOR(NULL, NULL);
            *head = node;
        }
    }
 
    else 
	{
        int Pos = 1;
        struct Node* curr = *head;
        struct Node* prev = NULL;
        struct Node* next = XOR(prev, curr->nxp);
 
        // Traverse the XOR linked list
        while (next != NULL && Pos < position - 1) 
		{
            prev = curr;
            curr = next;
            next = XOR(prev, curr->nxp);
            Pos++;
        }

        if (Pos == position - 1) {
 
            // Initialize a new Node
            struct Node* node= (struct Node*)malloc(sizeof(struct Node));
 
            // Stores pointer to previous Node
            // as (prev ^ next ^ next) = prev
            struct Node* temp = XOR(curr->nxp, next);
 
            // Stores XOR of prev and new node
            curr->nxp = XOR(temp, node);
 
            // Connecting new node with next
            if (next != NULL) {
                next->nxp = XOR(node,XOR(next->nxp, curr));
            }

            node->nxp = XOR(curr, next);
            node->data = value;
        }
 
        // Insertion node at beginning
        else if (position == 1) 
		{
            struct Node* node = (struct Node*)malloc(sizeof(struct Node));
            curr->nxp = XOR(node,XOR(NULL, curr->nxp));
            node->nxp = XOR(NULL, curr);
            *head = node;
            node->data = value;
        }
        else {
            printf("Invalid Position\n");
        }
    }
    return *head;
}

// Function to print elements of the XOR Linked List
void printList(struct Node** head)
{
	struct Node* curr = *head;
	struct Node* prev = NULL;
	struct Node* next;

	while (curr != NULL) {

		printf("%d ", curr->data);
		next = XOR(prev, curr->nxp);
		prev = curr;
		curr = next;
	}
	printf("\n");
}

// Function to reverse the linked
// list in the groups of K
struct Node* reverseK(struct Node** head,
                      int K, int len)
{
    struct Node* curr = *head;
  
    if (curr == NULL)
        return NULL;

    else if (len < K)
        return *head;
    else 
	{
        int count = 0;
        struct Node* prev = NULL;
        struct Node* next;
  
        while (count < K) 
		{
            next = XOR(prev, curr->nxp);
            prev = curr;
            curr = next;
            count++;
        }
  
        // Remove the prev node
        // from the next node
        prev->nxp = XOR(NULL,XOR(prev->nxp,curr));
  
        // Add the head pointer with prev
        (*head)->nxp = XOR(XOR(NULL,(*head)->nxp),curr);
  
        if (curr != NULL)
            curr->nxp = XOR(XOR(curr->nxp, prev),*head);
        return prev;
    }
}

// Function to reverse last K nodes
// of the given XOR Linked List
struct Node* reverse(struct Node* head, int nodes, int K)
{

	// Reverse the given XOR LL
	head = reverseK(&head, nodes, nodes);
	head = reverseK(&head, K, nodes);
	head = reverseK(&head, nodes, nodes);

	//printList(&head);
	return head;
}


int main()
{
	struct Node* head = NULL;
	int nodes = 0;
	char input[50];
    char command[20];
    char num[10];
    
    gets(input);
    char * token = strtok(input, " ");
    strcpy(command,token);
    int n = atoi(command);
    token = strtok(NULL," ");
    strcpy(num,token);
    int k = atoi(num);


    while(n-- > 0)
	{
		char input[50];
	    char command[20];
	    char num[10];
	    int number;
 	    gets(input);
	    char * token = strtok(input, " ");
	    strcpy(command,token);
	    if(strstr(command,"ADD") != NULL)
	    {
	    	nodes++;
	    	token = strtok(NULL," ");
		    strcpy(num,token);
		    int number = atoi(num);
		    insert(&head, number, nodes);
		}
		else if(strstr(command,"REVERSE") != NULL)
		{
			head = reverse(head,nodes,k);
		}
		else if(strstr(command,"print") != NULL)
		{
			printList(&head);
		}
    }
    printList(&head);
	return 0;
}
