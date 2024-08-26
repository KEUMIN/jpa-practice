package org.keumin.jpa_practice;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.keumin.jpa_practice.domain.Category;
import org.keumin.jpa_practice.domain.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaPracticeApplication {

    public static void main(String[] args) { SpringApplication.run(JpaPracticeApplication.class, args); }

}
