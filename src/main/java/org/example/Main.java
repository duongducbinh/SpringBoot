package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Laptop.class)
                .addAnnotatedClass(org.example.Alien.class)
                .configure()
                .buildSessionFactory(); //cfg.buildSessionFactory();
        Session session = sf.openSession();

        //use get
        //Laptop laptop = session.get(Laptop.class, 102);
        //System.out.println(laptop);

        //use load
        Laptop laptop2 = session.byId(Laptop.class).getReference(102);
        System.out.println(laptop2);
        session.close();
        sf.close();

    }
}