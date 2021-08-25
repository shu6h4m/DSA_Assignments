package PA2;
import java.util.*;

public class Main{
    public static void main(String[] args){
        //Driver code
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("*************************");
            System.out.println("          Menu");
            System.out.println("*************************");
            System.out.println("1. Circular Linked List \n2. Stack \n3. Infix to Postfix\n4. Evaluation of Expression\n0. Exit");
            System.out.println("*************************");
            System.out.print("Enter Option : ");
            int option = sc.nextInt();
            if(option == 0){
                
                break; //to exit from the menu.
            }
            else if(option == 1){
                //circular linked list.
                CircularLinkedList cll = new CircularLinkedList();
                while(true){
                    String value; int pos;
                    System.out.println("\n------------------------");
                    System.out.println("Circular Linked List Menu");
                    System.out.println("a). Insert at Front. \nb). Insert at End. \nc). Insert after value. \nd). Delete at Front. \ne). Delete at End. \nf). Delete at Position. \ng). Display the linked list. \nh). Size of Circular linked list. \ni). Check if linked list is Empty. \n0). Exit.");
                    System.out.println("--------------------------");
                    System.out.print("Enter Option : ");
                    char ch = sc.next().charAt(0);
                    if(ch == '0'){
                        //To exit from loop.
                        break;
                    }
                    switch(ch){
                        case 'a':
                            System.out.print("Enter the Value : ");
                            value = sc.next();
                            cll.addToFront(value);
                            break;
                        case 'b':
                            System.out.print("Enter the Value : ");
                            value = sc.next();
                            cll.addToEnd(value);
                            break;
                        case 'c':
                            System.out.print("Enter the Position after which you want to insert : ");
                            pos = sc.nextInt();
                            System.out.print("Enter the Value : ");
                            value = sc.next();
                            cll.addAfter(value,pos);
                            break;
                        case 'd':
                            cll.delAtFront();
                            break;
                        case 'e':
                            cll.delAtEnd();
                            break;
                        case 'f':
                            System.out.print("Enter the Postion :");
                            pos = sc.nextInt();
                            cll.delNode(pos);
                            break;
                        case 'g':
                            cll.display();
                            break;
                        case 'h':
                            System.out.println("Length of the Linked List is - "+cll.getLen());
                            break;
                        case 'i':
                            if(cll.isEmpty()){
                                System.out.println("Empty List !");
                            }else{
                                System.out.println("Not Empty !");
                            }
                            break;
                        default:
                            System.out.println("Please Enter Correct Choice.");
                            break;  
                    }

                }    
            }
            else if(option == 2){
                //Stack Operations.
                Stack st = new Stack();
                String value;
                while(true){
                    System.out.println("\n------------------------");
                    System.out.println("Stack Menu");
                    System.out.println("a). Push element. \nb). Pop element. \nc). Display top element. \nd). Display stack. \ne). Check if stack is empty. \n0). Exit.");
                    System.out.println("--------------------------");
                    System.out.print("Enter Option : ");
                    char ch = sc.next().charAt(0);
                    if(ch == '0'){
                        //To exit from loop.
                        break;
                    }
                    switch(ch){
                        case 'a':
                            System.out.print("Enter the Value to push : ");
                            value = sc.next();
                            st.push(value);
                            break;
                        case 'b':
                            st.pop();
                            break;
                        case 'c':
                            System.out.println("The Top element is - "+st.top());
                            break;
                        case 'd':
                            st.stDisplay();
                            break;
                        case 'e':
                            if(st.isEmptyStack()){
                                System.out.println("Stack is Empty.");
                            }else{
                                System.out.println("Stack is not Empty.");
                            }
                            break;
                        default:
                            System.out.println("Enter Correct Option !.");
                            break;  
                    }
                }
            }
            else if(option ==3){
                //Infix to postfix expression conversion.
                String exp;
                Infix_postfix itp = new Infix_postfix();
                while(true){
                    System.out.println("\n----------------------------");
                    System.out.println("Infix to Postfix Menu");
                    System.out.println("a). Convert infix to postfix. \n0). Exit.");
                    System.out.println("------------------------------");
                    System.out.print("Enter Option : ");
                    char ch = sc.next().charAt(0);
                    if(ch == '0'){
                        //To exit from loop.
                        break;
                    }
                    switch(ch){
                        case 'a':
                            System.out.print("Enter the Expression : ");
                            exp = sc.next();
                            if(itp.brac(exp)){
                                System.out.println("The Postfix Expression is - "+itp.inf_to_Post(exp));
                            }
                            else{
                                System.out.println("Brackets are not Balenced.");
                            }
                            break;
                        default:
                            System.out.println("Enter Correct choice !.");
                            break;  
                    }
                }
            } 
            else if(option == 4){
                //to evaluate postfix expression.
                String exp;
                Infix_postfix itp = new Infix_postfix();
                SolvePostfix sp = new SolvePostfix();
                while(true){
                    System.out.println("\n------------------------");
                    System.out.println("Infix to Postfix Menu");
                    System.out.println("a). To Evaluate Postfix Expression. \n0). Exit.");
                    System.out.println("--------------------------");
                    System.out.print("Enter Option : ");
                    char ch = sc.next().charAt(0);
                    if(ch == '0'){
                        //To exit from loop.
                        break;
                    }
                    switch(ch){
                        case 'a':
                            System.out.print("Enter the Expression : ");
                            exp = sc.next();
                            if(itp.brac(exp)){
                                System.out.println("The postfix Expression is - "+itp.inf_to_Post(exp));
                                System.out.println("The result after Evaluation = "+sp.evalPostfix(itp.inf_to_Post(exp)));
                            }
                            else{
                                System.out.println("Brackets are not Balenced.");
                            }
                            break;
                        default:
                            System.out.println("Enter Correct Choice !");
                            break;
                    }
                }
            }    
            
        }
    
    }
}