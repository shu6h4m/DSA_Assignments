package Assignment_5;

import java.util.Scanner;

public class callCenter {

    //driver code from package Assigment_5
    public static void main(String[] args) {

        //for user input
        Scanner input = new Scanner(System.in);

        //to access queue queue object is created
        queue Queue = new queue();
        while(true)
        {
            System.out.println("1. Add the call to waiting list");
            System.out.println("2. Attend the call");
            System.out.println("3. See the next call");
            System.out.println("4. Work End");
            System.out.print("What you want do? Select from above: ");

            char work = input.next().charAt(0);

            //to add call
            if( work=='1' )
            {
                System.out.println("\nEnter the mobile Number");
                while(true)
                {
                    String mobileNumber = input.next();
                    if( mobileNumber.length()==10 )
                    {
                        Queue.enqueue(mobileNumber);
                        break;
                    }
                    else 
                    {
                        System.out.println("Enter valid Mobile number");
                        continue;
                    }
                }
                System.out.println("\nCall is Added in waiting list Please hold the call.\n");
            }

            //to attend queue
            else if(work=='2')
            {
                if (Queue.isEmpty())
                {
                    System.out.println("\nNo more Calls.\n");
                    continue;
                }
                System.out.println("\nCall ongoing");
                while(true)
                {
                    System.out.print("\nTo end call type End: ");
                    if( input.next().equalsIgnoreCase("end") )
                        break;
                }
                Queue.dequeue();
                System.out.println("\nCall is Servered.\n");
            }

            //to see next call
            else if (work=='3')
            {
                if (Queue.isEmpty())
                {
                    System.out.println("\nNo more Calls in waiting list.\n");
                    continue;
                }
                System.out.println("\nNext customer number is: "+ Queue.front()+"\n");
            }

            //to finished work
            else if(work=='4')
            {
                System.out.println("\nGood Work today. See you tomorrow.\n");
                break;
            }
            else
                System.out.println("\nInvaid option.\n" );
        }
        input.close();
    }    
}
