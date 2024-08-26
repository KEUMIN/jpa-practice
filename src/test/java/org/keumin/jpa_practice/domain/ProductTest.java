package org.keumin.jpa_practice.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    @BeforeEach
    public void setup() {
        emf = Persistence.createEntityManagerFactory("test-pu");
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @AfterEach
    public void teardown() {
        if (tx.isActive()) {
            tx.rollback();
        }
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }

    @Test
    public void testCreateProduct() {
        Product product1 = new Product();
        product1.setName("testPrd1");
        product1.setCode("prd01");
        product1.setStock(10);

        Product product2 = new Product();
        product2.setName("testPrd2");
        product2.setCode("prd02");
        product2.setStock(10);

        Category category = new Category();
        category.setName("testCat");
        category.setCode("tc01");

        em.persist(product1);
        em.persist(product2);
        em.persist(category);
        List<Product> products = category.getProducts();
        products.add(product1);
        products.add(product2);

        tx.commit();

        Category retrievedCategory = em.find(Category.class, category.getId());
        List<Product> retrievedProducts = retrievedCategory.getProducts();
        assertEquals(retrievedProducts.size(), 2);
        assertEquals(retrievedProducts.get(0).getName(), product1.getName());
        assertEquals(retrievedProducts.get(1).getName(), product2.getName());
    }
}
