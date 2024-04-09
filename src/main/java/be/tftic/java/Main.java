package be.tftic.java;

import be.tftic.java.models.Employe;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel_db");

        Employe employe = new Employe();
        employe.setUsername("test");
        employe.setPassword("test");
        employe.setSalary(2000);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(employe);
        em.getTransaction().commit();

        new Scanner(System.in).nextLine();
        emf.close();
    }
}
