package Assignment_6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        dictionary dict = new dictionary();
        while(true)
        {
            System.out.println("1. Insert");
            System.out.println("2. Find Element");
            System.out.println("3. Delete Element");
            System.out.println("4. Display ");
            System.out.println("5. exit");
            

            char choice = input.next().charAt(0);
            if(choice=='5') break;
            
            switch (choice) {
                case '1':
                System.out.println("enter Rollno");
                String rollno = input.next();
                System.out.println("enter Name");
                String name= input.next();
                System.out.println("enter the DOB");
                String dob=input.next();
                System.out.println("enter the address");
                String addr=input.next();

                dictionary detail = new dictionary();
                detail.insertItem("Name", name);
                detail.insertItem("DOB", dob);
                detail.insertItem("Address", addr);
                boolean result =dict.insertItem(rollno, detail) ;
                if(result)
                    System.out.println("Record Added.");
                else
                {
                    System.out.println("Record already exist!, type yes to update it other wise type no");
                    if(input.next().equalsIgnoreCase("yes"))
                        System.out.println("Record updated. ");
                }
                break;

                case '2':
                System.out.println("Enter the roll no whose detail you want to Find");
                String rollno1 = input.next();
                String result1 = dict.findElem(rollno1);
                if(result1.equals(null))
                    System.out.println("No record found");
                else
                    System.out.println(result1);
                break;

                case '3':
                System.out.println("Enter the rollno");
                String roll =  input.next();
                boolean result2 = dict.removeItem(roll);
                if(!result2)
                    System.out.println("No record found");
                else
                    System.out.println("Record deleted");
                
                break;
                case '4':
                dict.elements(); 
                break;
                default:
                System.out.println("Invaid choice");
                    break;
            }
            System.out.println();
        }
    
        input.close();
    }
}
