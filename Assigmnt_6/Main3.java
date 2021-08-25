package Assignment_6;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true)
            {
            System.out.println("1.Chaning");
            System.out.println("2. Linear Probing");
            System.out.println("3. Double Hashing");
            System.out.println("4. Exit");

            char techChoice = input.next().charAt(0);
            if (techChoice == '4') break;
            else if(techChoice!='3' || techChoice!='2' || techChoice!= '1')
            {
                System.out.println("Wrong choice!! select again");
                continue;
            }
                chaining3 cain = new chaining3(5779);
                linearProbing3 linaer = new linearProbing3(5779);
                doubleHashing3 dou = new doubleHashing3(5779);

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

                    if(techChoice=='1')
                        result=cain.insert(rollno, detail) ;
                    else if(techChoice =='2')
                        result=linaer.insert(rollno, detail);
                    else 
                        result=dou.insert(rollno, detail);

                    if(result)
                        System.out.println("Record Added.");
                    else
                        System.out.println("Record already exist ");
                    break;

                    case '2':
                    System.out.println("Enter the roll no whose detail you want to Find");
                    String rollno1 = input.next();

                    if(techChoice=='1')
                        result=cain.search(rollno1) ;
                    else if(techChoice =='2')
                        result=linaer.search(rollno1);
                    else 
                        result=dou.search(rollno1);

                    if(!result)
                        System.out.println("No record found");
                    break;

                    case '3':
                    System.out.println("Enter the rollno");
                    String roll =  input.next();
                    if(techChoice=='1')
                        result=cain.delete(roll) ;
                    else if(techChoice =='2')
                        result=linaer.delete(roll);
                    else 
                        result=dou.delete(roll);
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
        }
        input.close();
    }
    
}
