package com.hibernate.controllers;

import com.hibernate.Index;
import com.hibernate.model.BankBranch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class BranchController {

    public static List<Integer> branchCode=new ArrayList<Integer>();
    static int bc=5556;
    public int createBranch(String address, String phone){

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BankBranch.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            BankBranch obj=new BankBranch(bc, address, phone);
            branchCode.add(bc);
            System.out.println("Saving the user");
            session.save(obj);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
        return bc++;
    }
}





