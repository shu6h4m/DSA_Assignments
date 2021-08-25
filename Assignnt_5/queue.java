package Assignment_5;

//class circularLinkedList is imported from Assigment_1 package
import Assigment_1.circularLinkedList;

/*
class circularLinkedList from Assigment is inherited by queue class

queue class function:
size() : return the size of queue
isEmpty() : check if queue is empty
enqueue() : inserted the element at end of queue
dequeue() : remove element at start of queue
front() : return the Starting/front element of queue
view() : display the queue 
*/
public class queue extends circularLinkedList{

    //return size of queue
    public int size()
    {
        return getSize();
    }

    //return true when queue if empty otherwise false
    public boolean isEmpty()
    {
        if ( size() == 0 ) return true;
        return false;
    }

    //insert the element at end of queue
    public void enqueue(String ele)
    {
        insertAtEnd(ele);
    }

    //remove element at front of queue
    public void dequeue() {
        deletAtEnd();
    }
    
    //return first/start element of queue
    public String front() {
        try {
            return super.start.getStringData();
        } 
        catch (Exception e) {
            return "\nStack is empty!!";
        }
    }

    //display the queue
    public void view() {
        if(isEmpty())
            System.out.println("Queue is Empty");
        else
            displayLinkedList();
    }
}
