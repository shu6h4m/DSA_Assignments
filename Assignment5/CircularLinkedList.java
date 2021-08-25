package Assignment5;

public class CircularLinkedList{
    /*
    Purpose:- This class is designed to perform following operation on Linked List as an ADT.
    functions:- addToEnd() : insert node at end.
                addToFront() : insert node at front.
                addAfter() : insert node after a specified node position.
                delAtFront() : delete node from front.
                delAtEnd() : delete node from end.
                delNode() : delete node at specified position.
                display() : display the linked list.
                isEmpty() : check whether the linked list is empty or not.
                getLen() : length of the linked list.
    */
    private int len = 0;
    protected Node head = null;
    protected Node tail = null;


    public void addToEnd(String value){
        /*
        Purpose:- insert node at end.
        Input:- String element "value" as an input.
        Output:- returns nothing but inserts element at the end(tail).
        */

        Node newNode = new Node(value);
        
        if(isEmpty()){  
            head= tail = newNode;
            head.nextNode = head.prevNode = tail.nextNode = tail.prevNode = head;
            len++;
            return;
        }

        Node lastNode = tail;
        tail = newNode;
        tail.nextNode = head;
        head.prevNode = lastNode.nextNode = tail;
        tail.prevNode = lastNode;
        len++;
    }


    public void addToFront(String value){
        /*
        Purpose:- insert node at front.
        Input:- String element "value" as an input.
        Output:- returns nothing but inserts element at the front(head).
        */
        Node newNode = new Node(value);

        if(isEmpty()){  
            head= tail = newNode;
            head.nextNode = head.prevNode = tail.nextNode = tail.prevNode = head;
            len++;
            return;
        }

        Node firstNode = head;
        head = newNode;
        head.nextNode = firstNode;
        firstNode.prevNode = tail.nextNode = head;
        head.prevNode = tail;
        len++;
    }


    public void addAfter(String value,int searchVal){
        /*
        Purpose:- insert node after a specified node position.
        Input:- String element "value" for new node and int element "searchVal" to earch for element in linked list.
        Output:- returns nothing but inserts element after searchVal.
        */
        if(searchVal==0){
            addToFront(value);
        }
        else if(searchVal==len-1){
            addToEnd(value);
        }
        else if(searchVal>0 && searchVal<len-1){
            Node newNode = new Node(value);
            Node mid = newNode;
            Node temp = head;
            for(int i=0; i<searchVal; i++){ 
                temp= temp.nextNode;
            }
            Node next_to_searchVal = temp.nextNode;

            temp.nextNode = next_to_searchVal.prevNode = mid;
            mid.nextNode = next_to_searchVal;
            mid.prevNode = temp;
            len++;
        }
        else{
            System.out.println("Deletion not possible!"); 
        }
        
    }


    public void delAtEnd(){
        /*
        Purpose:- delete node at end.
        Input:- none.
        Output:- returns nothing but delete element at the end(tail).
        */
        if(isEmpty()){
            System.out.println("The list empty!");
            return;
        }
        else if(len==1){
            head = tail = null;
        }
        else{
            Node temp = tail.prevNode;
            head.prevNode = temp;
            temp.nextNode = head;
            tail = temp;
        }
        len--;
    }


    public void delAtFront(){
        /*
        Purpose:- delete node at front.
        Input:- none.
        Output:- returns nothing but delete element at the front(head).
        */
        if(isEmpty()){
            System.out.println("The list empty!");
            return;
        }
        else if(len==1){
            head = tail = null;
        }
        else{
            Node temp = head.nextNode;
            tail.nextNode = temp;
            temp.prevNode = tail;
            head = temp;   
        }
        len--;
    }


    public void delNode(int pos){
        /*
        Purpose:- delete node at specified position.
        Input:- integer value "pos" to store the position.
        Output:- returns nothing but delete element at the positon(pos).
        */
        if(pos==0){
            delAtFront();
        }
        else if(pos==len-1){
            delAtEnd();
        }
        else if(pos>0 && pos<len-1){
            Node temp = head;
            for(int i=0; i<pos;i++){
                temp= temp.nextNode;
            }
            Node temp_next = temp.nextNode;
            Node temp_prev = temp.prevNode;
            temp_prev.nextNode = temp_next;
            temp_next.prevNode = temp_prev;
            len--;
        }
        else{
            System.out.println("Deletion not possible!"); 
        }   
    }


    public void display(){
        /*
        Purpose:- display linked list.
        Input:- none.
        Output:- prints the linked list.
        */
        Node temp = head;
        for(int i=1;i<=len;i++){
            System.out.print(" <=> "+temp.value );
            temp = temp.nextNode;
        }
        
    }


    public boolean isEmpty(){
        /*
        Purpose:- to check if linked list is empty.
        Input:- none.
        Output:- returns boolean value "true" if empty else "false".
        */
        return head == null;
    }


    public int getLen(){
        /*
        Purpose:- to get length of the linked list.
        Input:- none.
        Output:- returns length of the list.
        */
        return len;
    }
}