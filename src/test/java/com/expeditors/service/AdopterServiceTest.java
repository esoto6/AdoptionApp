package com.expeditors.service;

import com.expeditors.AdoptionAppConfig;
import com.expeditors.adopter.AdopterImpl;
import com.expeditors.adopter.Adopter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AdoptionAppConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("dev")
class AdopterServiceTest {

    @Autowired
    private AdopterService service;


    @Test
    void insertPerson() {

        Adopter person1 = new AdopterImpl("Edwin Soto", "843-693-7981", "edwin.soto@email.com", true);

        Adopter newPerson = service.insertPerson(person1);
        assertNotNull(newPerson);
        assertEquals(1, person1.getId());
    }

    @Test
    void deletePerson() {
        Adopter person1 = new AdopterImpl("Edwin Soto", "843-693-7981", "edwin.soto@email.com", true);

        Adopter newPerson = service.insertPerson(person1);
        assertNotNull(newPerson);

        boolean isDeleted = service.deletePerson(newPerson.getId());
        assertTrue(isDeleted);
    }

    @Test
    void updatePerson() {
        Adopter person1 = new AdopterImpl("Edwin Soto", "843-693-7981", "edwin.soto@email.com", true);

        Adopter newPerson = service.insertPerson(person1);
        assertNotNull(newPerson);

        // Update Person
        person1.setName("Not Edwin Soto");

        boolean isUpdated = service.updatePerson(person1);

        assertTrue(isUpdated);
    }

    @Test
    void getPerson() {
        Adopter person1 = new AdopterImpl("Edwin Soto", "843-693-7981", "edwin.soto@email.com", true);

        Adopter newPerson = service.insertPerson(person1);
        assertNotNull(newPerson);

        Adopter person = service.getPerson(1);

        assertEquals("Edwin Soto", person.getName());
    }

    @Test
    void getAllPersons() {

        Adopter person1 = new AdopterImpl("Edwin Soto", "843-693-7981", "edwin.soto@email.com", true);
        Adopter person2 = new AdopterImpl("Yao Ming", "843-111-1111", "yao.ming@email.com", false);
        Adopter person3 = new AdopterImpl("Liam Soto", "123-456-7890", "liam.soto@email.com");

        Adopter newPerson = service.insertPerson(person1);
        service.insertPerson(person2);
        service.insertPerson(person3);

        List<Adopter> persons = service.getAllPersons();

        assertEquals(3, persons.size());
    }
}