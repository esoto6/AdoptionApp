package com.edwinsoto.repository;

import com.edwinsoto.repository.jdbc.ConnectionDAO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles(profiles = "tc")
class ConnectionDAOTest extends ConnectionDAO {


    @Test
    @Disabled("Cannot extend TestcontainerConfig...")
    void testValidEnvConnection() throws SQLException {
        Connection connection = getConnection();
        assertNotNull(connection);
    }
}