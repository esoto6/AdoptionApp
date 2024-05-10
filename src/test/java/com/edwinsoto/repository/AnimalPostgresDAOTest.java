package com.edwinsoto.repository;

import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.ext.ScriptUtils;
import org.testcontainers.jdbc.JdbcDatabaseDelegate;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@DataJpaTest
@ActiveProfiles("test-containers")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AnimalPostgresDAOTest {

//    @Container
//    @ServiceConnection
//    static
//        PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16.0")
//                .withDatabaseName("adoption")
//                .withExposedPorts(5433)
//                .withUsername("larku")
//                .withPassword("larku")
//                .withCopyFileToContainer(MountableFile.
//                    forClasspathResource(
//                            "C:\\.Code\\Self-Development\\PluralSight\\AdoptionApp\\src\\main\\resources\\postgres\\schema.sql"),
//                    "/docker-entrypoint-initdb.d/init.sql");


//    static {
//        var postgres = new PostgreSQLContainer<>("postgres:16-alpine");
//        postgres.start();
//    }

    @Autowired
    private AnimalPostgresDAO animalPostgresDAO;

    @Test
    @Sql("/schema.sql")
    void connectionEstablished(){
        System.out.println("Hello");
//        assertThat(postgres.isCreated()).isTrue();
//        assertThat(postgres.isRunning()).isTrue();
    }
    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}