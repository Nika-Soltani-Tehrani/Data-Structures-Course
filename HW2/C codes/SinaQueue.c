#include<stdlib.h>
#include <stdio.h>
#include <string.h>



void display();
void to_front(int);
void push_back(int);
void front();
void back();
 
 
struct node
{
    int info;
    struct node *next;
};
struct node *start=NULL;
struct node *tail=NULL;
int main()     
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
		/*else if(strstr(command,"display"))
		{
			display();
		}*/
    }
    return 0;
}
void display()
{
        struct node *ptr;
        if(start==NULL)
        {
            printf("\n");
            return;
        }
        else
        {
            ptr=start;
            while(ptr!=NULL)
            {
                printf("%d",ptr->info );
                ptr=ptr->next ;
            }
            printf("\n");
        }
}
void to_front(int num)
{
        struct node *temp;
        temp=(struct node *)malloc(sizeof(struct node));
        temp->info = num;
        temp->next =NULL;
        if(start==NULL)
        {
            start=temp;
        }
        else
        {
            temp->next=start;
            start=temp;
        }
}
void push_back(int num)
{
        struct node *temp,*ptr;
        temp=(struct node *)malloc(sizeof(struct node));
        temp->info = num;
        temp->next =NULL;
        if(start==NULL)
        {
            start=temp;
        }
        else
        {
            ptr=start;
            while(ptr->next !=NULL)
            {
                    ptr=ptr->next ;
            }
            ptr->next =temp;
        }
}
void front()
{
        struct node *ptr;
        ptr=start;
        start=start->next ;
        printf("%d\n",ptr->info);
        free(ptr);
}
void back()
{
        struct node *temp,*ptr;
        if(start->next ==NULL)
        {
            ptr=start;
            start=NULL;
            printf("%d\n",ptr->info);
            free(ptr);
        }
        else
        {
            ptr=start;
            while(ptr->next!=NULL)
            {
                temp=ptr;
                ptr=ptr->next;
            }
            temp->next=NULL;
            printf("%d\n",ptr->info);
            free(ptr);
        }
}