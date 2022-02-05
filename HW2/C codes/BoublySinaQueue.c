#include<stdio.h>  
#include<stdlib.h>  
#include<string.h>
struct node  
{  
    struct node *prev;  
    struct node *next;  
    int data;  
};  
struct node *head;
struct node *tail;  
void to_front(int);  
void push_back(int);  
void front();  
void back();   
void display();  
int main ()  
{
	int numbers;
    int size = 0;
    int reversed = 0;
    scanf("%d ",&numbers);
    while(numbers-- > 0)
	{
		char input[50];
	    char command[20];
	    char num[10];
	    int number;
 	    gets(input);
	    char * token = strtok(input, " ");
	    strcpy(command,token);
	    if(strstr(command,"push_back") != NULL)
	    {
	    	token = strtok(NULL," ");
		    strcpy(num,token);
		    int number = atoi(num);
		    if(size >= 50000)
            {
            	printf("No more space :(\n");
			}
			else
			{
				size++;
				if(reversed == 0)
					push_back(number);
				else
					to_front(number);
			}
		}
		else if(strstr(command,"to_front") != NULL)
		{
			token = strtok(NULL," ");
		    strcpy(num,token);
		    int number = atoi(num);
		    if(size >= 50000)
            {
            	printf("No more space :(\n");
			}
			else
			{
				size++;
				if(reversed == 0)
					to_front(number);
				else
					push_back(number);
			}
		}
		else if(strstr(command,"front") != NULL)
		{
			if(size > 0)
			{
				size--;
				if(reversed == 0)
					front();
				else
					back();
			}
			else
				printf("No job :)\n");
		}
		else if(strstr(command,"back") != NULL)
		{
			if(size > 0)
			{
				size--;
				if(reversed == 0)
					back();
				else
					front();
			}
			else
				printf("No job :)\n");
		}
		else if(strstr(command,"reverse") != NULL)
		{
			if(reversed == 1)
				reversed = 0;
			else
				reversed = 1;
		}
		else if(strstr(command,"display"))
		{
			display();
		}
    }
    return 0;
}  
void to_front(int item)  
{  
   struct node *ptr;
   ptr = (struct node *)malloc(sizeof(struct node));
   if(head==NULL)  
   {  
       ptr->next = NULL;  
       ptr->prev=NULL;  
       ptr->data=item;  
       head=ptr;  
   }  
   else   
   {  
       ptr->data=item;  
       ptr->prev=NULL;  
       ptr->next = head;  
       head->prev=ptr;  
       head=ptr;  
   }  
}  
      
void push_back(int item)  
{  
    struct node *ptr,*temp;  
    ptr = (struct node *) malloc(sizeof(struct node));    
    ptr->data=item;
    ptr->next=NULL;
    if(head == NULL)  
    {   
       ptr->prev = NULL;  
       head = ptr;
       tail = ptr;
       //printf("%d\n",tail->data);
    }

    else  
    {  
        /*temp = head;  
        while(temp->next!=NULL)  
        {  
            temp = temp->next;  
        }   
        temp->next = ptr;  
        ptr ->prev=temp;  
        ptr->next = NULL; */
        ptr->prev = tail;
	    tail->next = ptr;
    	tail = ptr;
    	//printf("%d\n",tail->data);
        /*ptr=start;
        while(ptr->next !=NULL)
        {
                ptr=ptr->next ;
        }
        ptr->next =temp;*/ 
    }  
	//printf("%d\n",head->data);  
}  

void front()  
{  
    struct node *ptr;  

    if(head->next == NULL)  
    {
		printf("%d\n",head->data);
        head = NULL;
        tail = NULL;
        free(tail);
        free(head);
    }  
    else  
    {
    	printf("%d\n",head->data);
        ptr = head;
        head = head -> next;
        head -> prev = NULL;
        free(ptr);
    }  
  
}  


void back()  
{  
    struct node *temp; 
    if(head->next == NULL)  
    {
    	printf("%d\n",head->data);
        head = NULL;
        tail = NULL;
        free(tail);
        free(head);   
    }
    else   
    {
    	/*printf("%d\n",tail->data);
    	printf("%d\n",tail->prev->data);
    	//temp = tail;
    	temp->prev = tail->prev->prev;
    	printf("%d\n",tail->prev->prev->data);
    	temp = tail->prev;
    	temp->next = NULL;
    	tail = temp;
    	free(temp);*/
        temp = head;   
        while(temp->next != NULL)  
        {  
            temp = temp -> next; 
			tail = temp;  
        }
        temp -> prev -> next = NULL;
        printf("%d\n",temp->data);
        free(temp); 
		 
    }  
}  

void display()
{  
    struct node *ptr;  
    ptr = head;  
    while(ptr != NULL)  
    {  
        printf("%d ",ptr->data);  
        ptr=ptr->next;  
    } 
	printf("\n"); 
}   
  