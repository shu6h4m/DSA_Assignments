package Assignment5;

import java.util.Scanner;
import java.util.Random;

public class CallDataBase{
    /*
    Purpose:- This class is designed to perform following operation on parenthesis checking.
    functions:- addToDatabase() : check whether a String's or expression's parenthesis is balenced.
    */

    Queue q = new Queue();

    public void addToDatabase(String value,boolean isBusy){
        /*
        Purpose:- This function is designed to store calls in queue until care is ready to take the call.
        Input:- takes String "value"  as an input(data of caller) and boolean "isBusy" as an input(conditon of care).
        Output:- returns nothing but maintains the queue.
        */
        if(isBusy){
            q.enqueue(value);
            System.out.println("Call of the person is in waiting .");
        }
        else{
            if(q.isEmptyQueue()){
                System.out.println("Call of the person is served :"+ value);
            }
            else{
                q.enqueue(value);
                System.out.println("Call of the person is served :"+q.displayFront());
                q.dequeue();
            }   
        }
        System.out.print("People in queue : ");
        q.displayQueue();
    }


    public static void main(String[] args){
        //Driver code.
        Scanner sc = new Scanner(System.in);
        CallDataBase cdb = new CallDataBase();
        while(true){
            Random r = new Random();
            boolean isBusy = r.nextBoolean();

            System.out.print("Enter the caller : ");
            String value = sc.next();

            cdb.addToDatabase(value,isBusy);

            System.out.print("\nEnter '1' to continue, '0' to exit : ");
            int op = sc.nextInt();
            if(op==0){
                break;             //to end the loop.
            }
        }     
    }
}
