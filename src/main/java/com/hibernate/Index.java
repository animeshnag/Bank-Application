package com.hibernate;

import com.hibernate.controllers.MainController;


public class Index {

    public static void main(String[] args){

        System.out.println("WELCOME TO SBI PRIME BANKING APPLICATION");
        MainController con=new MainController();
        con.start();
    }
}
