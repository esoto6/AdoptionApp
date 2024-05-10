package com.edwinsoto.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(profiles="dev")
class AbstractDAOTest extends AbstractDAO {


    @Test
    void testValidEnvConnection() throws SQLException {
        Connection connection = getConnection();
        assertNotNull(connection);
    }
}