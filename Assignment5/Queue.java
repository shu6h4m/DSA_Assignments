package Assignment5;

import java.util.Scanner;

public class Queue {
    /*
    Purpose:- This class is designed to perform operation on Stack Operations.
    function:- enqueue() : enqueue element into the queue.
               dequeue() : dequeue element from queue.
               displayFront() : show the fron element of the queue.
               displayQueue() : display the queue.
               isEmptyQueue() : check if queue is empty.
    */

    CircularLinkedList cll = new CircularLinkedList();

    public void enqueue(String value){
        /*
        Purpose:- This function is designed to enqueue element into the queue.
        Input:- takes String value "value" as an input.
        Output:- returns nothing but enqueue element into the stack.
        */
        cll.addToEnd(value);
    }

    public void dequeue(){
        /*
        Purpose:- This function is designed to dequeue the element form the queue.
        Input:- none.
        Output:- returns nothing but dequeue the element from the queue.
        */
        if(isEmptyQueue()){
            System.out.println("Queue is empty.");
            return;
        }
        cll.delAtFront();
    }

    public String displayFront(){
        /*
        Purpose:- This function is designed to get the front element of the queue.
        Input:- none.
        Output:- returns front element of the queue or the message.
        */
        if(isEmptyQueue()){
            return "Queue is empty.";
        }
        return cll.head.value;
    }

    public void displayQueue(){
        /*
        Purpose:- This function is designed to display the queue.
        Input:- none.
        Output:- returns nothing but prints the stack or displays the message.
        */
        if(isEmptyQueue()){
            System.out.println("Queue is empty.");
            return;
        }
        cll.display();
    }

    public boolean isEmptyQueue(){
        /*
        Purpose:- This function is designed to check if queue is empty.
        Input:- none.
        Output:- returns boolean value "true" if queue is empty else "false".
        */
        return cll.isEmpty();
    }


    public static void main(String[] args){

        Queue q = new Queue();
        Scanner sc = new Scanner(System.in);
        while(true){
            String value;
            System.out.println("\n------------------------Menu-------------------------");
            System.out.println("1. Enqueue.\n2. Dequeue.\n3. Display front of queue.\n4. Display queue. \n5. To check if empty.");
            System.out.println("-----------------------------------------------------");
            System.out.print("Enter the option : ");
            int op = sc.nextInt();
                    if(op == 0){
                        //To exit from loop.
                        break;
                    }
                    switch(op){
                        case 1:
                            System.out.print("Enter the value : ");
                            value = sc.next();
                            q.enqueue(value);
                            break;
                        case 2:
                            q.dequeue();
                            break;
                        case 3:
                            System.out.print(q.displayFront());
                            break;
                        case 4:
                            q.displayQueue();
                            break;
                        case 5:
                            if(q.isEmptyQueue()){
                                System.out.println("Queue is empty!");
                            }else{
                                System.out.println("Queue is not empty!");
                            }
                            break;
                        default:
                            System.out.println("Oops!! Wrong choice. please choose again.");
                            break;  
                    }
        }
    }
}
