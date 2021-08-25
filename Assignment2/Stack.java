package PA2;

//class to perform operation on Stack Operations
public class Stack extends CircularLinkedList{

    //Function to push element into the stack   
    public void push(String value){
        addToFront(value);
    }


    //Function to pop the element form the stack
    public void pop(){
        delAtFront();
    }


    //Function to get the top element of the stack
    public String top(){
        if(isEmptyStack()){
            return "Sorry! Stack Empty.";
        }
        else{
            return head.value;
        }
    }


    //Function to display the stack
    public void stDisplay(){
        if(isEmptyStack()){
            System.out.println("Sorry! Empty Stack.");
            return;
        }
        display();
    }


    //Function to check if stack is empty
    public boolean isEmptyStack(){
        return isEmpty();
    }
}