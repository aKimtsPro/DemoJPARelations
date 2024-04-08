package be.tftic.java;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel_db");

        System.out.println("waiting");
        Thread.sleep(2000);

        emf.close();
    }
}
