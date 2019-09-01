/* CS1101 “ Intro to Computer Science
Instructor: Aguirre
Comprehensive Lab 1
By including my name below I confirm that:
- I am submitting my original work.
- If I include code obtained from another
source or I received help I am giving
attribution to those sources as comments.
- This submission does not incur in any
academic dishonesty practice as described in
the course syllabus.
Modified and submitted by: Jacob Hampton
*/ 

import java.util.*;
import java.io.*;

public class minerBank{
public static void main(String[]args) throws Exception{





//*********************************************************Asking the user for their credentials***************************************************************

Scanner userScan = new Scanner(System.in);
boolean cont = true;
boolean fileCheck = true;
int userPass;
String userName;

for(int i = 0; i < 3; i++){
 //initialize the file we want to read
 File theFile = new File("users.txt");

 //initialize the scanner to read the file
 Scanner console = new Scanner(theFile);

 //read name
 String name = console.next();

 //read password
 int passWord = console.nextInt(); 

 //read checking
 double checking = console.nextInt(); 

 //read saving
 double saving = console.nextInt();
 
 userName = getUserName();
 userPass = getPass();
 if(!(name.equals(userName)) && (!(userPass == passWord))){
  while(console.hasNext() && fileCheck){
    name = console.next();
    passWord = console.nextInt();
    checking = console.nextInt();
    saving = console.nextInt();
    if(name.equals(userName) && (userPass == passWord)){
     fileCheck = false;
    }
    
  }//end while
 }//end if
 if(name.equals(userName) && (userPass == passWord)){
  //credentials match
  while(cont){//*****************************************************Start of outer while************************************************************************
   System.out.println("Welcome to minerBank! Enter the menu option you want (1 to 5):");
   System.out.println("1. Check Balance\n2. Withdraw Money\n3. Deposit Money\n4. Transfer Money\n5. Exit");
   int choice = userScan.nextInt();
   
   while(choice > 5 || choice < 1){
    System.out.println("You need to enter 1, 2, 3, 4, or 5.");
    System.out.println("1. Check Balance\n2. Withdraw Money\n3. Deposit Money\n4. Transfer Money\n5. Exit");
    choice = userScan.nextInt();
   }//end while
   
   switch(choice){
    case 1://****************************************VIEW ACCOUNT**********************************************************************************
     System.out.println("Select one of the following options:\n1. Checking Account:\n2. Savings Account");
     int viewMoney = userScan.nextInt();
     while(viewMoney!= 1 && viewMoney != 2){
      System.out.println("Enter 1 or 2!");
      viewMoney = userScan.nextInt();
     }//end while
     switch(viewMoney){
      case 1:
       System.out.printf("Amount in checking: $%.2f\n", checking);
       break;
      case 2:
       System.out.printf("Amount in savings: $%.2f\n", saving);
       break;
     }//end switch
     break;
    case 2://**************************************************SAVINGS*****************************************************************************
     System.out.println("Select one of the following accounts to withdraw from:\n1. Checking Account:\n2. Savings Account");
     int withChoice = userScan.nextInt();
     while(withChoice != 1 && withChoice != 2){
      System.out.println("Enter 1 or 2");
      withChoice = userScan.nextInt();
     }//end while
     double withAmt;
     switch(withChoice){
      case 1://CHECKING WITHDRAWAL
       System.out.println("Enter the amount you wish to withdraw");
       withAmt = userScan.nextDouble();
       while(withAmt > 200 || (checking - withAmt < 0)){
        System.out.println("Sorry that is not a valid amount\nPlease try again.");
        withAmt = userScan.nextDouble();
       }
       checking -= withAmt;
       System.out.printf("Your final balance is: $%.2f\n",checking);
       break;
      case 2://SAVINGS WITHDRAWAL
       System.out.println("Enter the amount you wish to withdraw");
       withAmt = userScan.nextDouble();
       while(withAmt > 200 || (saving - withAmt < 0)){
        System.out.println("Sorry that is not a valid amount\nPlease try again.");
        withAmt = userScan.nextDouble();
       }
       saving -= withAmt;
       System.out.printf("Your final balance is: $%.2f\n",saving);
       break;
     }//end switch
     break;
    case 3://**************************************************DEPOSIT*****************************************************************************
     System.out.println("Select one of the following accounts to Deposit to:\n1. Checking Account:\n2. Savings Account");
     int depChoice = userScan.nextInt();
     while(depChoice != 1 && depChoice != 2){
      System.out.println("Enter 1 or 2");
      depChoice = userScan.nextInt();
     }//end while
     double depAmt;
     switch(depChoice){
      case 1://CHECKING DEPOSIT
       System.out.println("Enter the amount you wish to deposit");
       depAmt = userScan.nextDouble();
       while(depAmt > 1200 || depAmt <= 0){
        System.out.println("Sorry that is not a valid amount\nPlease try again");
        depAmt = userScan.nextDouble();
       }//end while
       checking += depAmt;
       System.out.printf("Your final balance is: $%.2f\n",checking);
       break;
      case 2://SAVINGS DEPOSIT
       System.out.println("Enter the amount you wish to deposit");
       depAmt = userScan.nextDouble();
       while(depAmt > 1200 || depAmt <=0){
        System.out.println("Sorry that is not a valid amount\nPlease try again");
        depAmt = userScan.nextDouble();
       }//end while
       saving += depAmt;
       System.out.printf("Your final balance is: $%.2f\n",saving);
       break;
     }//end switch
     break;
    case 4://************************************************************TRANSFER******************************************************************
     System.out.println("Select one of the following accounts to withdraw from:\n1. Checking Account:\n2. Savings Account");
     int tranChoice = userScan.nextInt();
     while(tranChoice != 1 && tranChoice != 2){
      System.out.println("Enter 1 or 2");
      tranChoice = userScan.nextInt();
     }//end while
     double tranAmt;
     switch(tranChoice){
      case 1://TRANSFER TO SAVINGS
       System.out.println("How much would you like to transfer to savings?");
       tranAmt = userScan.nextDouble();
       while(tranAmt > 200 || (checking - tranAmt) < 0){
        System.out.println("Sorry that is not a valid amount\nPlease try again");
        System.out.println("How much would you like to transfer to savings?");
        tranAmt = userScan.nextDouble();
       }//end while
       saving += tranAmt;
       checking -= tranAmt;
       System.out.println();
       System.out.printf("Your final balance in checking is $%.2f\nYour final balance in savings is $%.2f\n", checking, saving);
       break;
      case 2://TRANSFER TO CHECKING
       System.out.println("How much would you like to transfer to checking?");
       tranAmt = userScan.nextDouble();
       while(tranAmt > 200 || (saving - tranAmt) < 0){
        System.out.println("Sorry that is not a valid amount\nPlease try again");
        System.out.println("How much would you like to transfer to checking?");
        tranAmt = userScan.nextDouble();
       }//end while
       checking += tranAmt;
       saving -= tranAmt;
       System.out.println();
       System.out.printf("Your final balance in savings is: $%.2f\nYour final balance in checking is: $%.2f\n", saving, checking);
       break;
     }//end switch
     break;
    case 5:
     System.out.println("Thank You for using the Miner Bank. Goodbye");
     cont = !cont;
     break;
    
   }//end switch
 }//***********************************************************End of outer while*************************************************************************** 
  break;//leaves for loop
 
 }else{
  System.out.println("You entered the wrong username and/or password.");
  
  //User has failed to enter the correct information 3 times
  if(i == 2){
   System.out.println("You have failed to enter the correct credentials 3 times");
  }
 }
 
}//end for




}//end of main



//Methods
public static String getUserName(){
 Scanner meth = new Scanner(System.in);
 System.out.println("Enter username: ");
 String userName = meth.nextLine();
 return userName;
}//end getUserName

public static int getPass(){
 int userPass;
 try{
  Scanner meth = new Scanner(System.in);
  System.out.println("Enter pin: ");
  userPass = meth.nextInt();
 }catch(Exception e){
  System.out.println("Please enter a valid pin");
  Scanner meth = new Scanner(System.in);
  System.out.println("Enter pin: ");
  userPass = meth.nextInt();
 }
  return userPass;
}//end getPass








}//end of class
