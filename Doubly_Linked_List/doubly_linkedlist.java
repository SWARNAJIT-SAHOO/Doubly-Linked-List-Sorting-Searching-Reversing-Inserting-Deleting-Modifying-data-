import java.util.*;
class doubly_linkedlist {
    //doubly_linkedlist node;
    class node{
        int d;
        node n,p;
        node(int data){
            d =data;
            n = null;
            p=null;
        }
    }
    node head=null;
    Scanner p = new Scanner(System.in); 

    void insert_f(int val){
        node tem = new node(val);
        if(head==null){
            head=tem;
        }
        else{
            head.p=tem;
            tem.n=head;
            head=tem;
        }
    }
    void insert_l(int val){
        node tem = new node(val);
        if(head==null){
            head=tem;
        }
        else{
            node i =head;
            while(i.n!=null){
                i=i.n;
            }
            i.n=tem;
            tem.p=i;
        }
    }
    void insert_random(int val){
        if(head==null){
            System.out.println("List is empty so, -");
            insert_f(val);
        }
        else{
            node tem = new node(val);
            System.out.print("Enter the POSITION to insert : ");
            int po= p.nextInt();
            node i =head;
            // node j=i;
            if(po==0){
                tem.n=i;
                i.p=tem;
                head=tem;
            }
            else{
                int k=1;
                while(k<po){
                    // j=i;
                    i=i.n;
                    k++;
                }
                if(i.n==null){
                    i.n=tem;
                    tem.p=i;
                }else{
                    tem.n=i.n;
                    tem.p=i;
                    i.n=tem;
                }
            }
            System.out.println("NEW LIST : ");
            show();
        }
    }

    void delete_f(){
        if(head==null){
            System.out.println("List is Empty.");
        }
        else{
            node i =head;
            head=i.n;
        }
    }

    void delete_l(){
        if(head==null){
            System.out.println("List is Empty.");
        }
        else{
            node i =head;
            if(i.n==null){
                head=null;
            }
            else{
                while(i.n!=null){
                    i=i.n;
                }
                i.p.n=null;
            }
        }
    }
    void delete_random(){
        if(head==null){
            System.out.println("List is Empty.");
        }
        else{
            System.out.print("Enter a the POSITION to DELETE : ");
            int po = p.nextInt();
            node i = head;
            node j= i;
            if(po==1){
                delete_f();
            }
            int k=1,c=0;
            while(k!=po){
                j=i;
                i=i.n;
                if(i==null){
                    System.out.println("INVALID POSITION .");
                     c=1;
                    
                }
                k++;
            }
            if(i.n==null && c!=1){
                delete_l();
            }
            else if(c!=1){
                i.n.p=j;
                j.n=i.n;
            }
        }
    }
    void show(){
        if(head==null){
            System.out.println("List is Empty.");
        }
        else{
            node i =head;
            while(i!=null){
                System.out.print("<--"+i.d+"-->");
                i=i.n;
            }
        }
        System.out.println();
    }
    void search(){
        if(head==null){
            System.out.println("List is Empty.");
        }
        else{
            System.out.print("Enter the number to SEARCH : ");
            int n1 = p.nextInt();
            int po=1,k=0;
            node i =head;
            while(i.d!=n1){
                i=i.n;
                po++;
                if(i==null){
                    System.out.println();
                    System.out.println(n1+"--INVALID NUMBER");
                    System.out.println("Enter a valid Number.");
                    search();
                    k=1;
                    break;
                }
            }
            if(k!=1){
                System.out.println("The number "+i.d+" is at "+po+" POSITION");
            }
        }
    }
    void replace(){
        if(head==null){
            System.out.println("List is Empty.");
        }
        else{
            System.out.print("Enter the value TO BE replace  : ");
                int v = p.nextInt();
                System.out.print("Enter the NEW value : ");
                int r= p.nextInt();
                node tem= new node(r);
                node i =head;
                int c=0;
                if(v==i.d){
                    tem.n=head.n;
                    i.n.p=tem;
                    head=tem;
                }
                else{
                    while(i.d!=v){
                    i=i.n;
                    if(i==null){
                    System.out.println(v+"--INVALID NUMBER");
                    System.out.println("Enter a valid Number.");
                    c=1;
                    break;
                    }
                }
                if(i.n==null && c!=1 ){
                    i.p.n=tem;
                    tem.p=i.p;
                }
                else if(c!=1){
                    tem.n=i.n;
                    tem.p=i.p;
                    i.p.n=tem;
                    i.n.p=tem;
                }
            }
            System.out.println("NEW LIST :  ");
            show();
        }
    }

    void acending(){
        node i=head;
        node j=i;
        int tem;
        System.out.println();
        for(i=head;i!=null;i=i.n){
            for(j=i;j!=null;j=j.n){
                if(i.d>j.d){
                    tem = i.d;
                    i.d=j.d;
                    j.d=tem;
                }
            }
            System.out.print("<--"+i.d+"-->");
        }
        System.out.println();
    }
    void decending(){
        node i=head;
        node j=i;
        int tem;
        System.out.println();
        for(i=head;i!=null;i=i.n){
            for(j=i;j!=null;j=j.n){
                if(i.d<j.d){
                    tem = i.d;
                    i.d=j.d;
                    j.d=tem;
                }
            }
            System.out.print("<--"+i.d+"-->");
        }
        System.out.println();
    }

    void sorting(){
        if(head==null){
            System.out.println("List is Empty.");
        }
        else{
            System.out.println("\t1.Asecending order ");
            System.out.println("\t2.descending order ");
            System.out.print("Enter your choice : ");
            int c =p.nextInt();
            if(c==1){
                acending();
            }
            else if(c==2){
                decending();
            }
            else{
                System.out.println("Enter valid Option.");
                sorting();
            }
        }
    }
    node rev(node i){
        if(i.n==null){
            System.out.print("<--"+i.d+"-->");
            return i;
        }
        else{
            rev(i.n);
            System.out.print("<--"+i.d+"-->");
        }
        return i;
    }
    void reverse(){
        if(head==null){
            System.out.println("List is Empty.");
        }
        else{
            node i = head;
            System.out.println("REVERSED LIST : ");
            rev(i);
            System.out.println();
        }
    }

}
class doubl{
    public static void main(String[] k){
        int c=1,val;
        Scanner sc = new Scanner(System.in);
        
        doubly_linkedlist list  = new doubly_linkedlist();
        while(c!=12){
            System.out.print("*-----------------------*");
            System.out.println("\n|\t1.insert_first\t|\n|\t2.insert_last\t|\n|\t3.delete_first\t|\n|\t4.delete_last\t|\n|\t5.show\t\t|\n|\t6.delete_random\t|\n|\t7.insert_random\t|\n|\t8.search\t|\n|\t9.sorting\t|\n|\t10.reverse\t|\n|\t11.replace\t|\n|\t12.exit\t\t|");
            System.out.println("*-----------------------*");
            System.out.print("Enter Your Choice : ");
            c = sc.nextInt();
            System.out.println();
            switch(c){
                case 1:
                System.out.print("enter the number to be inserted : ");
                val = sc.nextInt();
                list.insert_f(val);
                break;
            case 2:
                System.out.print("enter the number to be inserted : ");
                val = sc.nextInt();
                list.insert_l(val);
                break;
            case 3:
                list.delete_f();
                break;
            case 4:
                list.delete_l();
                break;
            case 5:
                 list.show();
                break;
            case 6:
                 list.delete_random();
                break;
            case 7:
                System.out.print("enter the number to be inserted : ");
                val = sc.nextInt();
                 list.insert_random(val);
                break;
            case 8:
                 list.search();
                break;
            case 9:
                 list.sorting();
                break;
            case 10: 
                System.out.print(" ");
                 list.reverse();
                break;
            case 11:
                 list.replace();
                break;
            case 12:
                break;
            default:
                System.out.print("enter a valid number.");
       }
        }
        sc.close();
    }
}



/*OUTPUT */
/*
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 1

enter the number to be inserted : 11
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 2

enter the number to be inserted : 12
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 2

enter the number to be inserted : 13
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 2

enter the number to be inserted : 14
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 2

enter the number to be inserted : 15
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 5

<--11--><--12--><--13--><--14--><--15-->
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 3

*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 5

<--12--><--13--><--14--><--15-->
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 4

*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 5

<--12--><--13--><--14-->
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 1

enter the number to be inserted : 11
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 2

enter the number to be inserted : 15
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 5

<--11--><--12--><--13--><--14--><--15-->
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 6

Enter a the POSITION to DELETE : 1
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 5

<--12--><--13--><--14--><--15-->
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 7

enter the number to be inserted : 0
Enter the POSITION to insert : 0
NEW LIST :
<--0--><--12--><--13--><--14--><--15-->
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 11

Enter the value TO BE replace  : 0
Enter the NEW value : 11
NEW LIST :
<--11--><--12--><--13--><--14--><--15-->
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 10

 REVERSED LIST :
<--15--><--14--><--13--><--12--><--11-->
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 8

Enter the number to SEARCH : 13
The number 13 is at 3 POSITION
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 5

<--11--><--12--><--13--><--14--><--15-->
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 9

        1.Asecending order
        2.descending order
Enter your choice : 2

<--15--><--14--><--13--><--12--><--11-->
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 9

        1.Asecending order
        2.descending order
Enter your choice : 1

<--11--><--12--><--13--><--14--><--15-->
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 11

Enter the value TO BE replace  : 13
Enter the NEW value : 3
NEW LIST :
<--11--><--12--><--3--><--14--><--15-->
*-----------------------*
|       1.insert_first  |
|       2.insert_last   |
|       3.delete_first  |
|       4.delete_last   |
|       5.show          |
|       6.delete_random |
|       7.insert_random |
|       8.search        |
|       9.sorting       |
|       10.reverse      |
|       11.replace      |
|       12.exit         |
*-----------------------*
Enter Your Choice : 12*/
