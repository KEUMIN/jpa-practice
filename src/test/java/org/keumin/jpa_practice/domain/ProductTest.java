package org.keumin.jpa_practice.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Product product = new Product();
        product.setName("testPrd");
        product.setPrice(30000);
        product.setStock(10);

        Category category = new Category();
        category.setName("testCat");
        category.setCode("tc01");

        em.persist(product);
        em.persist(category);
        product.setCategory(category);

        tx.commit();

        Product retrivedProduct = em.find(Product.class, product.getId());
        assertEquals(product.getName(), retrivedProduct.getName());
        assertEquals(product.getPrice(), retrivedProduct.getPrice());
        assertEquals(product.getStock(), retrivedProduct.getStock());
    }
}
