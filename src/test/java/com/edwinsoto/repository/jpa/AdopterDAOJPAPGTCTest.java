package com.edwinsoto.repository.jpa;

import com.edwinsoto.model.Adopter;
import com.edwinsoto.testcontainer.TestContainerConfig;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Testcontainers
@DataJpaTest
@ActiveProfiles("tc_jpa")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AdopterDAOJPAPGTCTest extends TestContainerConfig {

    private final AdopterJPA jpaRepo;

    @Autowired
    AdopterDAOJPAPGTCTest(AdopterJPA jpaRepo) {
        this.jpaRepo = jpaRepo;
    }


    @Test
        //@Order(2)
    void findAll() {
        List<Adopter> adopters = jpaRepo.findAll();
        assertThat(adopters).hasSize(5);
    }

}