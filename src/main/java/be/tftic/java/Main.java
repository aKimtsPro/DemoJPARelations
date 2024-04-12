package be.tftic.java;

import be.tftic.java.models.Employe;
import be.tftic.java.models.Employe_;
import be.tftic.java.models.Hotel;
import be.tftic.java.repository.EmployeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel_db");

        EmployeRepository repo = new EmployeRepository(emf);

        List<Employe> employes = repo.findByWorksInCity_Criteria("Gosselies");

        employes.forEach(System.out::println);

        emf.close();
    }
}
