package org.keumin.jpa_practice.domain;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.keumin.jpa_practice.domain.QCategory.category;
import static org.keumin.jpa_practice.domain.QProduct.*;

@SpringBootTest
@Transactional
public class QuerydslProductTest {
    @Autowired
    private EntityManager em;

    private JPAQueryFactory queryFactory;

    @BeforeEach
    public void setup() {
        queryFactory = new JPAQueryFactory(em);

        Category category = new Category();
        category.setName("testCat");
        category.setCode("tc01");

        Product product1 = new Product();
        product1.setName("testPrd1");
        product1.setCode("prd01");
        product1.setStock(10);
        product1.setCategory(category);

        Product product2 = new Product();
        product2.setName("testPrd2");
        product2.setCode("prd02");
        product2.setStock(10);
        product2.setCategory(category);

        em.persist(product1);
        em.persist(product2);
        em.persist(category);

        em.flush();
        em.clear();
    }

    @Test
    public void testGetProductByCodeAndName() {
        Product prd = queryFactory.select(product)
                .from(product)
                .where(
                        product.code.eq("prd01"),
                        product.name.eq("testPrd1")
                )
                .fetchOne();
        assertThat(prd.getCode()).isEqualTo("prd01");
        assertThat(prd.getName()).isEqualTo("testPrd1");
    }

    @Test
    public void testGetProductByCategoryName() {
        List<Product> products = queryFactory
                .select(product)
                .from(product)
                .join(product.category, category)
                .where(category.name.eq("testCat"))
                .fetch();

        assertThat(products).hasSize(2);
        assertThat(products.get(0).getCode()).isEqualTo("prd01");
        assertThat(products.get(1).getCode()).isEqualTo("prd02");
    }

    @Test
    public void testGetProductNameAndCategoryName() {
        List<Tuple> info = queryFactory
                .select(product.name,
                        JPAExpressions
                                .select(category.name)
                                .from(category))
                .where(category.id.eq(product.category.id))
                .from(product)
                .fetch();

        assertThat(info).hasSize(2);
        assertThat(info.get(0).get(0, String.class)).isEqualTo("testPrd1");
        assertThat(info.get(0).get(1, String.class)).isEqualTo("testCat");
        assertThat(info.get(1).get(0, String.class)).isEqualTo("testPrd2");
        assertThat(info.get(1).get(1, String.class)).isEqualTo("testCat");
    }
}
