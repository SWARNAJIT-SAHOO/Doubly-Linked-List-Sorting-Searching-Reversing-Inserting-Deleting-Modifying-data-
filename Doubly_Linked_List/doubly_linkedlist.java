import java.util.*;
class doubly_linkedlist {
    doubly_linkedlist node;
    node head;
    class node{
    int d;
    node n,p;
    node(int data){
        d =data;
        n = null;
        p=null;
    }
    }
    Scanner p = new Scanner(System.in); 

    void insert_f(doubly_linkedlist l,int val){
        node tem = new node(val);
        if(l.head==null){
            l.head=tem;
        }
        else{
            l.head.p=tem;
            tem.n=l.head;
            l.head=tem;
        }
    }
    void insert_l(doubly_linkedlist l,int val){
        node tem = new node(val);
        if(l.head==null){
            l.head=tem;
        }
        else{
            node i =l.head;
            while(i.n!=null){
                i=i.n;
            }
            i.n=tem;
            tem.p=i;
        }
    }
    void insert_random(doubly_linkedlist l,int val){
        if(l.head==null){
            System.out.println("List is empty so, -");
            insert_f(l,val);
        }
        else{
            node tem = new node(val);
            System.out.print("Enter the POSITION to insert : ");
            int po= p.nextInt();
            node i =l.head;
            // node j=i;
            if(po==0){
                tem.n=i;
                i.p=tem;
                l.head=tem;
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
            show(l);
        }
    }

    void delete_f(doubly_linkedlist l){
        if(l.head==null){
            System.out.println("List is Empty.");
        }
        else{
            node i =l.head;
            l.head=i.n;
        }
    }

    void delete_l(doubly_linkedlist l){
        if(l.head==null){
            System.out.println("List is Empty.");
        }
        else{
            node i =l.head;
            if(i.n==null){
                l.head=null;
            }
            else{
                while(i.n!=null){
                    i=i.n;
                }
                i.p.n=null;
            }
        }
    }
    void delete_random(doubly_linkedlist l){
        if(l.head==null){
            System.out.println("List is Empty.");
        }
        else{
            System.out.print("Enter a the POSITION to DELETE : ");
            int po = p.nextInt();
            node i = l.head;
            node j= i;
            if(po==1){
                delete_f(l);
            }
            int k=1,c=0;
            while(k!=po ){
                j=i;
                i=i.n;
                if(i==null){
                    System.out.println("INVALID POSITION .");
                     c=1;
                    break;
                }
                k++;
            }
            if(i.n==null && c!=1){
                delete_l(l);
            }
            else if(c!=1){
                i.n.p=j;
                j.n=i.n;
            }
        }
    }
    void show(doubly_linkedlist l){
        if(l.head==null){
            System.out.println("List is Empty.");
        }
        else{
            node i =l.head;
            while(i!=null){
                System.out.print("<--"+i.d+"-->");
                i=i.n;
            }
        }
        System.out.println();
    }
    void search(doubly_linkedlist l){
        if(l.head==null){
            System.out.println("List is Empty.");
        }
        else{
            System.out.print("Enter the number to SEARCH : ");
            int n1 = p.nextInt();
            int po=1,k=0;
            node i =l.head;
            while(i.d!=n1){
                i=i.n;
                po++;
                if(i==null){
                    System.out.println();
                    System.out.println(n1+"--INVALID NUMBER");
                    System.out.println("Enter a valid Number.");
                    search(l);
                    k=1;
                    break;
                }
            }
            if(k!=1){
                System.out.println("The number "+i.d+" is at "+po+" POSITION");
            }
        }
    }
    void replace(doubly_linkedlist l){
        if(l.head==null){
            System.out.println("List is Empty.");
        }
        else{
            System.out.print("Enter the value TO BE replace  : ");
                int v = p.nextInt();
                System.out.print("Enter the NEW value : ");
                int r= p.nextInt();
                node tem= new node(r);
                node i =l.head;
                int c=0;
                if(v==i.d){
                    tem.n=l.head.n;
                    i.n.p=tem;
                    l.head=tem;
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
            show(l);
        }
    }

    void acending(doubly_linkedlist l){
        node i=l.head;
        node j=i;
        int tem;
        System.out.println();
        for(i=l.head;i!=null;i=i.n){
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
    void decending(doubly_linkedlist l){
        node i=l.head;
        node j=i;
        int tem;
        System.out.println();
        for(i=l.head;i!=null;i=i.n){
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

    void sorting(doubly_linkedlist l){
        if(l.head==null){
            System.out.println("List is Empty.");
        }
        else{
            System.out.println("\t1.Asecending order ");
            System.out.println("\t2.descending order ");
            System.out.print("Enter your choice : ");
            int c =p.nextInt();
            if(c==1){
                acending(l);
            }
            else if(c==2){
                decending(l);
            }
            else{
                System.out.println("Enter valid Option.");
                sorting(l);
            }
        }
    }
    node rev(doubly_linkedlist l ,node i){
        if(i.n==null){
            System.out.print("<--"+i.d+"-->");
            return i;
        }
        else{
            rev(l,i.n);
            System.out.print("<--"+i.d+"-->");
        }
        return i;
    }
    void reverse(doubly_linkedlist l){
        if(l.head==null){
            System.out.println("List is Empty.");
        }
        else{
            node i = l.head;
            System.out.println("REVERSED LIST : ");
            rev(l,i);
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
                list.insert_f(list,val);
                break;
            case 2:
                System.out.print("enter the number to be inserted : ");
                val = sc.nextInt();
                list.insert_l(list,val);
                break;
            case 3:
                list.delete_f(list);
                break;
            case 4:
                list.delete_l(list);
                break;
            case 5:
                 list.show(list);
                break;
            case 6:
                 list.delete_random(list);
                break;
            case 7:
                System.out.print("enter the number to be inserted : ");
                val = sc.nextInt();
                 list.insert_random(list,val);
                break;
            case 8:
                 list.search(list);
                break;
            case 9:
                 list.sorting(list);
                break;
            case 10: 
                System.out.print(" ");
                 list.reverse(list);
                break;
            case 11:
                 list.replace(list);
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