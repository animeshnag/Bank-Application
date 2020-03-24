package com.hibernate.controllers;

import com.hibernate.model.BankBranch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;


public class BankBranches {
    public static int printAvailableBranchCode(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BankBranch.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            List<BankBranch> bb =session.createQuery("from BankBranch").getResultList();
            System.out.println("Available Bank Branches are");
            for(int x=0; x<bb.size(); x++){
                System.out.println(bb.get(x).getId() + " ");
            }
            session.getTransaction().commit();
            return bb.size();
        }
        finally {
            factory.close();
        }
    }

    public static boolean getNoOfAvailableBranches(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BankBranch.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();try {
            session.beginTransaction();
            List<BankBranch> bb =session.createQuery("from BankBranch").getResultList();
            session.getTransaction().commit();
            if(bb.size() > 0)
                return true;
            else
                return false;
        }
        finally {
            factory.close();
        }
    }

}





