package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

/*
        Laptop laptop2 = new Laptop();
        laptop2.setId(102);
        laptop2.setBrand("Asus");
        laptop2.setModel("ROG");
        laptop2.setRam(16);

        Laptop laptop3 = new Laptop();
        laptop3.setId(103);
        laptop3.setBrand("HP");
        laptop3.setModel("Pavilion");
        laptop3.setRam(8);

        Alien alien = new Alien();
        alien.setAid(1);
        alien.setAname("John");
        alien.setTech("Java");

        Alien alien2 = new Alien();
        alien2.setAid(2);
        alien2.setAname("Doe");
        alien2.setTech("Python");

        laptop.setAlien(alien);
        laptop2.setAlien(alien);
        laptop3.setAlien(alien2);

         */

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Laptop.class)
                .addAnnotatedClass(org.example.Alien.class)
                .configure()
                .buildSessionFactory(); //cfg.buildSessionFactory();
        Session session = sf.openSession();
/*

        Student st = session.get(Student.class, 5);
        Transaction ts = session.beginTransaction();

        session.persist(laptop);
        session.persist(laptop2);
        session.persist(laptop3);

        session.persist(alien);
        session.persist(alien2);

        ts.commit();

     */
        String brand = "Dell";
        Query query = session.createQuery("select model, ram from Laptop where brand like ?1");
        query.setParameter(1, brand);
        List<Object[]> laptops = query.getResultList();

        for(Object[] data : laptops){
            System.out.println(data[0] + " " + data[1]);
        }
        session.close();
        sf.close();

    }
}