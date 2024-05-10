package com.edwinsoto.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDAO {

    @Autowired
    private Environment env;


    protected Connection getConnection() throws SQLException {
//        String url = "jdbc:postgresql://localhost:5433/adoption";
//        String user = "larku";
//        String password = "larku";
        String url = env.getProperty("spring.datasource.url");
        String user = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");


        return DriverManager.getConnection(url, user, password);
    }
}
