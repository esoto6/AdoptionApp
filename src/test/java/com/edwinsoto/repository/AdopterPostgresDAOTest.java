package com.edwinsoto.repository;

import com.edwinsoto.model.Adopter;
import com.edwinsoto.testcontainer.TestContainerConfig;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest(classes = AdopterPostgresDAO.class)
@ActiveProfiles("tc")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdopterPostgresDAOTest extends TestContainerConfig {


    @Autowired
    private AdopterPostgresDAO adopterPostgresDAO;


    @Test
    @Order(2)
    void findAll() {
        List<Adopter> adopters = adopterPostgresDAO.findAll();
        assertThat(adopters).hasSize(5);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, Edwin Soto",
            "2, Spouse Soto",
            "3, Kido One Soto",
            "4, Kido Two Soto",
            "5, Kido Three Soto"
    })
    @Order(3)
    void findById(Integer adopterID, String adopterName) {
        Optional<Adopter> adopter = adopterPostgresDAO.findById(adopterID);
        assertThat(adopter).isPresent();
        assertThat(adopter.get().getName()).isEqualTo(adopterName);
    }

    @Test
    @Order(4)
    @Disabled("Not working...")
    void findByInvalidID() {
        Optional<Adopter> adopter = adopterPostgresDAO.findById(-1);
        assertThat(adopter).isNotPresent();
    }

    @Test
    @Order(5)
    void create() {
        Adopter adopter = Adopter.builder()
                .name("New Adopter")
                .phoneNumber("000-888-8889")
                .build();

        Adopter newAdopter = adopterPostgresDAO.create(adopter);

        assertThat(newAdopter).isNotNull();
        assertThat(newAdopter.getName()).isEqualTo(adopter.getName());
        assertThat(newAdopter.getPhoneNumber()).isEqualTo(adopter.getPhoneNumber());
        assertThat(adopterPostgresDAO.findById(newAdopter.getId())).isPresent();
    }

    @Test
    @Order(6)
    void update() {
        Adopter adopterIdx1 = adopterPostgresDAO.findById(1).get();
        adopterIdx1.setName("Not Edwin");
        adopterPostgresDAO.update(adopterIdx1);

        Optional<Adopter> adopter = adopterPostgresDAO.findById(1);
        assertThat(adopter).isPresent();
        assertThat(adopter.get().getName()).isEqualTo(adopterIdx1.getName());

    }

    @Test
    @Order(7)
    void delete() {
        Adopter adopteridx1 = adopterPostgresDAO.findById(1).get();
        assertThat(adopteridx1).isNotNull();

        int rowsAffected = adopterPostgresDAO.delete(1);
        assertThat(rowsAffected).isEqualTo(1);
    }
}