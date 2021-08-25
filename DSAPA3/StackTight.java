/*
Programming Assignment 3
program to :
a.  Implement (growable using tight strategy) Stack as an ADT 
using arrays with the operations discussed in the lectures.

b. Use the ADT of part (a) to find if a given string of 
characters drawn from the english alphabet, is a pallindrome.
*/

//package DSAPA3;
import java.util.Arrays;
import java.util.Scanner;

//Class definition
public class StackTight {

    String[] stackArray;
    int top;
    int maxSize;
    int constSize;

//constructor
    StackTight(int size)
    {
        top = -1;
        maxSize = size;
        constSize=size;
        stackArray = new String[size];
    }

//to check if stack is empty or not
    public boolean isEmpty() {
        if ( top == -1 )
            return true;
        return false;
    }

//return size of stack
    public int size()
    {
        return top+1;
    }

//push the element in stack
    public String push( String element ) {
        if ( size() == maxSize )
        {
            maxSize = constSize + stackArray.length;
            stackArray = Arrays.copyOf(stackArray, maxSize);
        }
        top++;
        stackArray[ top ] = element;

        return "Inserted Succesfully !!";
    }

//pop element form stack
    public String pop() {
        if ( isEmpty() )
            return "Stack is Empty !!";
        top--;
        return "Deleted Sucessfully !!" ;       
    }

//return top element of stack
    public String top() {
        if ( isEmpty() )
            return "Stack is Empty !!";
        return stackArray[ top ];
    }

//to display stack
    public void viewStack() {
        if ( isEmpty() )
            System.out.println("\nStack is Empty !!");
        else
           System.out.println("Stack: \n"+Arrays.toString( Arrays.copyOf(stackArray, size() ) ));
    }
    
//Function to check if string is pallindrom or not
    public boolean checkpall( String word, StackTight stk ) {
        String reverseWord="";
        for(int i=0 ; i<word.length() ; i++)
            stk.push(Character.toString(word.charAt(i)));

        while(!stk.isEmpty())
        {
            reverseWord += stk.top();
            stk.pop();
        }

        if ( word.equals(reverseWord) )
            return true;
        return false;
    }
//Main class definition
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true)
        {
            System.out.println("\n1. Stack Operations");
            System.out.println("2. Check if Word is Pallindrome");
            System.out.println("3. Exit");
            System.out.print("\nEnter an Option from above: ");

            char choice = input.next().charAt(0);

            if ( choice=='3' )
                break;

            //to access stack operations
            else if (choice=='1')
            {
                System.out.print("\nEnter the size of Stack: ");
                int size = input.nextInt();
                StackTight stk = new StackTight(size);

                while(true)
                    {
                    System.out.println("\n1. Push");
                    System.out.println("2. Pop");
                    System.out.println("3. Show top element");
                    System.out.println("4. Size of Stack");
                    System.out.println("5. Check if stack is Empty");
                    System.out.println("6. Display Stack");
                    System.out.println("7. Exit");
                    System.out.print("\nEnter optiopn from above: ");

                    char stackMenu = input.next().charAt(0);
                    System.out.println("***********************");
                    switch (stackMenu) {
                        case '1':
                            System.out.print("\nEnter the Element: ");        
                            String value = input.next();
                            System.out.println(stk.push(value) );
                            break;   
                        case '2':
                            System.out.println( stk.pop() );
                            break;
                        
                        case '3':
                            System.out.println("\nTop Element is:\n "+stk.top());
                            break;
                        
                        case '4':
                            System.out.println("\nSize of stack: "+stk.size());
                            break;
                        
                        case '5':
                            if (stk.isEmpty())
                                System.out.println("\nStack is empty!!");
                            else
                                System.out.println("\nStack is not empty!!");
                            break;
                        case '6':
                            stk.viewStack();
                            break;
                        case '7':
                            System.exit(0);
                    
                        default:
                            System.out.println("\nInvlaid option!! try again");
                            break;
                    }
                    System.out.println("\n***********************");
                }
            }
            //to check if string is palindrome 
            else if(choice=='2')
            {
                System.out.println("\n***********************");
                StackTight stk =new StackTight(5);
                System.out.println("\nEnter the word: \n");

                String word = new String( input.next() );

                if(stk.checkpall(word, stk))
                    System.out.println("\nString is Pallindrome");
                else
                    System.out.println("\nString is not Pallindrome");
                System.out.println("\n***********************");
            }
            else
                System.out.println("Enter the correct option!!");  
        }
        input.close();
    }
}