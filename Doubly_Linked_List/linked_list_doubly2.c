#include<stdio.h>
#include<stdlib.h>

struct node{
    struct node *p,*n;
    int d;
};
struct node* head= NULL;

void insert_f(int val){
    struct node*tem = (struct node*)malloc(sizeof(struct node));
    tem->d =val;
    tem->p =NULL;
    tem->n=NULL;
    if(head==NULL){
        head=tem;
    }
    else{
        tem->n=head;
        head->p=tem;
        head=tem;
    }
}

void insert_l(int val){
    struct node* tem=(struct node*)malloc(sizeof(struct node));
    tem->d=val;
    tem->n=NULL;
    tem->p=NULL;
    if(head==NULL){
        head=tem;
    }
    else{
        struct node* i= head;
        while(i->n!=NULL){
            i=i->n;
        }
        tem->p=i;
        i->n=tem;
    }
}

void insert_random(int val){
    struct node*tem=(struct node*)malloc(sizeof(struct node));
    tem->d=val;
    tem->p=NULL;
    tem->n=NULL;
    if(head==NULL){
        head=tem;
    }
    else{
        int po,j=1;
        printf("enter the position to insert : ");
        scanf("%d",&po);
        struct node* i =head;
        while(j<po){
            i=i->n;
            j++;
        }
        if(po==0){
            insert_f(val);
        }
        else if(i->n!=NULL){
                tem->n=i->n;
                i->n->p=tem;
                i->n=tem;
        }
        else{
            insert_l(val);
        }
        
        // tem->n=i->n;
    }
}
void delete_f(){
    if(head==NULL){
        printf("List is empty.");
    }
    else{
        struct node*tem=head;
        head=tem->n;
        // head->p=NULL;
        tem->n=NULL;
        free(tem);
    }
}
void delete_l(){
    if(head==NULL){
        printf("List is empty.");
    }
    else{
        struct node*i =head;
        struct node* j;
        while(i->n!=NULL){
            j=i;
            i=i->n;
        }
        i->p=NULL;
        j->n=NULL;
        // i->p->n=NULL;
        free(i);
    }
}

void delete_random(){
    if(head==NULL){
        printf("List is empty.");
    }
    else{
        int po,j=1;
        printf("enter the Position to DELETE : ");
        scanf("%d",&po);
        struct node*i = head;
        struct node*tem;
        while(j<po){
            i=i->n;
            j++;
        }
        if(po==0){
            delete_f();
        }
        else if(i->n!=NULL){
        
            i->n->p=i->p;
            i->p->n=i->n;
            // i->n=NULL; if we do null to both pointer varoiable then it will break the chain
            // i->p=NULL;
            free(i);
        }
        else{
            delete_l();
        }
    }
}

void show(){
    if(head==NULL){
        printf("List is empty.");
    }
    else{
        struct node* i =head;
        while(i!=NULL){
            printf("<--%d-->",i->d);
            i=i->n;
        }
    }
}
void search(){
    if(head==NULL){
        printf("List is empty.");
    }
    else
    {
    int no,po=1;
    printf("enter the number to be searched : ");
    scanf("%d",&no);
    printf("\n");
    struct node *i =head;
    while(i->d!=no || i->n!=NULL){
        po++;
        i=i->n;
    }
    if(po!=0){
        printf("The Number %d is At %d Position.",no,po);
    }
    else{
        printf("The Number %d is not present.",no);
    }
    }
}
void ascending(struct node* i,struct node*j,int tem){
    printf("List in Ascending Order: ");
        for(i=head;i!=NULL;i=i->n){
            for(j=i->n;j!=NULL;j=j->n){
                if(i->d > j->d){
                    tem=i->d;
                    i->d=j->d;
                    j->d=tem;
                }
            }
            printf("<--%d-->",i->d);
    }
}
void desending(struct node* i,struct node*j,int tem){
    printf("List in Ascending Order: ");
        for(i=head;i!=NULL;i=i->n){
            for(j=i->n;j!=NULL;j=j->n){
                if(i->d < j->d){
                    tem=i->d;
                    i->d=j->d;
                    j->d=tem;
                }
            }
            printf("<--%d-->",i->d);
    }
}
void sorting(){
    if(head==NULL){
        int val;
        printf("\nSince , List is empty.");
        printf("\nenter a value : ");
        scanf("%d",&val);
        insert_f(val);
        printf("\nInserted value: ");
        show();
    }
    else{
        struct node*i = head;
        struct node*j;
        int tem,o;
        printf("\nEnter - 1.Ascending Order\n\t2.Descending Order");
        printf("\nenter your choice : ");
        scanf("%d",&o);
        if(o==1){
            ascending(i,j,tem);
        }
        else if(o==2){
            desending(i,j,tem);
        }
        else{
            printf("enter a valid option.");
            sorting();
        }
        
}
}

struct node* reverse(struct node *i){
        if(i->n==NULL){
            printf("<--%d-->",i->d);
            return i;
        }
        reverse(i->n);
        printf("<--%d-->",i->d);
}


int main(){
    int c,val;
    while(c!=11){
    printf("\n1.insert_first\n2.insert_last\n3.delete_first\n4.delete_last\n5.show\n6.delete_random\n7.insert_random\n8.search\n9.sorting\n10.reverse\n11.exit");
    printf("\nenter your choice : ");
    scanf("%d",&c);
    switch(c){
        case 1:
                printf("enter the value to be inserted : ");
                scanf("%d",&val);
                insert_f(val);
                break;
        case 2:
                printf("enter the value to be inserted : ");
                scanf("%d",&val);
                insert_l(val);
                break;
        case 3:
                delete_f();
                break;
        case 4:
                delete_l();
                break;
        case 5:
                show();
                break;
        case 6:
                delete_random();
                break;
        case 7:
                printf("enter the value to be inserted : ");
                scanf("%d",&val);
                insert_random(val);
                break;
        case 8:
                search();
                break;
        case 9:
                sorting();
                break;
        case 10:
        		printf("");
                struct node*i = head;
                reverse(i);
                break;
        case 11:
                break;
        default:
            printf("enter a valid number.");
    }
    }
}
