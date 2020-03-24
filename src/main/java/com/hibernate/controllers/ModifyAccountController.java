package com.hibernate.controllers;

import com.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class ModifyAccountController {

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .buildSessionFactory();
    Session session = factory.getCurrentSession();
    String accNo="";
    public void modifyAccount() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Select one category according to your choice");
        System.out.println("Press 1 to edit you name");
        System.out.println("Press 2 to edit you Aadhar Card");
        System.out.println("Press 3 to withdraw money");
        System.out.println("Press 4 to submit money");
        int ch = sc.nextInt();
        System.out.println(MainController.accountNumbers);
        if(MainController.accountNumbers.isEmpty()){
            System.out.println("Sorry their is no account in the bank");
        }
        else {
            System.out.println("Please enter your 8 digit Account Number");
            accNo = sc.next();
            if (!(MainController.accountNumbers.contains(accNo))) {
                System.out.println("Sorry this account no " + accNo + "does not exist");
            } else {
                if (ch == 1) {
                    System.out.println("Enter your new name");
                    String newName = sc.next();
                    editname(newName);
                    System.out.println("*****************************************************");
                    System.out.println("Your Name has been updated Succesfully");
                    System.out.println("*****************************************************");
                } else if (ch == 2) {
                    //editAadhaarCard();
                } else if (ch == 3) {
                    System.out.println("Enter the amount of money you want to withdraw");
                    int withdrawAmt = sc.nextInt();
                    validateAccountBalance(withdrawAmt);
                } else if (ch == 4) {
                    System.out.println("Enter the amount of money you want to withdraw");
                    int creditAmount = sc.nextInt();
                    //credit(creditAmount);
                }
            }
        }
    }

    public void editname(String newName){

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting User with Account No : " + accNo);
            User userobj = session.get(User.class, accNo);

            System.out.println("Changing Name");
            System.out.println(userobj);

            userobj.setName(newName);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
    public boolean validateAccountBalance(int withdraw_amt){

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting User with Account No : " + accNo);
            User userobj = session.get(User.class, accNo);

            System.out.println("Validating");
            System.out.println(userobj);

            int presentBalance=userobj.getBalance();
            if(presentBalance<withdraw_amt){
                System.out.println("*****************************************************");
                System.out.println("Sorry insufficient balance");
                System.out.println("*****************************************************");
            }
            else{
                presentBalance=presentBalance-withdraw_amt;
                userobj.setBalance(presentBalance);
            }

            session.getTransaction().commit();
            System.out.println("Done!");
            return true;
        }
        finally {
            factory.close();
        }
    }
}
