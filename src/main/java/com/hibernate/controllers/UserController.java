package com.hibernate.controllers;

import com.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserController {

    public boolean createUser(String accountNo, String name, String aadharCardNo, int balance, int branchCode){

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            User obj=new User(accountNo, name, aadharCardNo, balance, branchCode);
            System.out.println("Saving the user");
            session.save(obj);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
        return true;
    }
}





