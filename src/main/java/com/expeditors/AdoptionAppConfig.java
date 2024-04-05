package com.expeditors;

import com.expeditors.dao.DAOFactory;
import com.expeditors.dao.PersonDAO;
import com.expeditors.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ResourceBundle;


@Configuration
@ComponentScan({"com.expeditors"})
public class AdoptionAppConfig {

    private static String profile;

    private static ResourceBundle bundle = ResourceBundle.getBundle("backend");

    static {
        profile = bundle.getString("backend.profile");
    }

    @Bean
    public PersonDAO getPersonDAO() {
        return DAOFactory.getPersonDAO();
    }

    @Bean(name = "personService")
    public PersonService getService() {
        var service = new PersonService();
        service.setPersonDAO(getPersonDAO());
        return service;
    }
}

