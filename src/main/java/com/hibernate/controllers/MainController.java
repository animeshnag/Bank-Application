package com.hibernate.controllers;

import java.util.ArrayList;
import java.util.Scanner;
import static com.hibernate.controllers.BranchController.branchCode;

public class MainController {

    static int acctNo=9999;
    public static ArrayList<String> accountNumbers=new ArrayList<String>();
    Scanner sc=new Scanner(System.in);

    public void start(){
        char ans='@';
        int ch=1;
        do {
            System.out.println("SELECT 1 IF YOU ARE A USER AND SELECT 2 IF YOU ARE A BANK PROFESSIONAL");
            String ch1 = sc.next();
            try {
                 ch= Integer.parseInt(ch1);

            switch (ch) {
                case 1:
                    System.out.println("PRESS 1 IF YOU ALREADY HAVE A ACCOUNT AND WANT TO WITHDRAW OR UPDATE PROFILE\nPRESS 2 IF YOU ARE NEW USER AND WANT TO CREATE ACCOUNT");
                    int user = sc.nextInt();
                    if (user == 1) {
                        ModifyAccountController mac=new ModifyAccountController();
                        mac.modifyAccount();
                    }
                    else if (user == 2) {

                        if(BankBranches.getNoOfAvailableBranches()) {
                            BankBranches.printAvailableBranchCode();

                            System.out.println("Enter the branch code in which you want to open your account");
                            int bcode = sc.nextInt();
                                System.out.println("Enter your Name");
                                String name=sc.next();
                                System.out.println("Enter your Aadhar Card No");
                                String aadhaarCardNo=sc.next();

                                String accountNo = bcode + "" + acctNo;
                                accountNumbers.add(accountNo);
                                acctNo--;

                                UserController uc = new UserController();
                                boolean userCreated = uc.createUser(accountNo, name, aadhaarCardNo, 0, bcode);
                                if (userCreated) {
                                    System.out.println("*******************************************************************************");
                                    System.out.println("Congratualation Your Zero balance Account has been created and your 8 dight account no is " + accountNo);
                                    System.out.println("Your Account Details are\n");
                                    System.out.println("Name\t\t\t\t" + name);
                                    System.out.println("Account No\t\t\t" + accountNo);
                                    System.out.println("Aadhar Card No\t\t" + aadhaarCardNo);
                                    System.out.println("Balance\t\t\t\t" + "0");
                                    System.out.println("SBI Branch Code\t\t" + bcode);

                                    System.out.println("*******************************************************************************\n");
                                } else {
                                    System.out.println("*******************************************************************************\n");
                                    System.out.println("Some problem occured\n\n");
                                    System.out.println("*******************************************************************************\n");
                                }
                        }
                        else{
                            System.out.println("Sorry for the inconvenience. Presently their is no branch where your account can be created\n\n");
                        }
                    }
                    else
                        System.out.println("Wrong input");
                    break;

                case 2:
                    System.out.println("Enter your address");
                    String address=sc.next();
                    System.out.println("Enter phone number");
                    String phone=sc.next();
                    BranchController bc = new BranchController();
                    int bcode=bc.createBranch(address, phone);
                    System.out.println("*******************************************************************************");
                    System.out.println("Congratulations your SBI Branch has been opened and its branch Code is "  + bcode);
                    System.out.println("*******************************************************************************");
                    break;

                default:
                    System.out.println("Enter the right choise");
            }
            }
            catch (NumberFormatException e){
                System.out.println("Invalid Input");
            }
            System.out.println("*******************************************************************************");
            System.out.println("Do you want continue. Press any key to continuue or Press 'n' to stop");
            System.out.println("*******************************************************************************");

                    ans=sc.next().charAt(0);
        }while(ans!='n');
    }
}
