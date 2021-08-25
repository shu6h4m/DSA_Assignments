package Assignment_6;

import java.util.Scanner;

public class UniversalHashingMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        universalHashing uni = new universalHashing(5779);

        while(true)
        {
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Search");
            System.out.println("4. exit");
            

            char choice = input.next().charAt(0);
            if(choice=='4') break;
            boolean result;
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

                result=uni.insert(rollno, detail) ;
                
                if(result)
                    System.out.println("Record Added.");
                else
                    System.out.println("Record already exist ");
                break;

                case '2':
                System.out.println("Enter the roll no whose detail you want to Find");
                String rollno1 = input.next();
  
                result=uni.search(rollno1) ;
  
                if(!result)
                    System.out.println("No record found");
                break;

                case '3':
                System.out.println("Enter the rollno");
                String roll =  input.next();
                
                result=uni.delete(roll);
                
                if(!result)
                    System.out.println("No record found");
                else
                    System.out.println("Record deleted");
                
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
