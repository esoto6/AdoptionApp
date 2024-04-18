package com.edwinsoto.service;

import static org.junit.jupiter.api.Assertions.*;

import com.edwinsoto.adopter.AdopterService;
//import com.edwins.AdoptionAppConfig;
import com.edwinsoto.adopter.AdopterImpl;
import com.edwinsoto.adopter.Adopter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {AdoptionAppConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
@SpringBootTest
class AdopterServiceTest {

    @Autowired
    private AdopterService adopterService;


    @Test
    void insertPerson() {

        Adopter person1 = new AdopterImpl("Edwin Soto", "111-222-3333", "edwin.soto@email.com", true);

        Adopter newPerson = adopterService.insertPerson(person1);
        assertNotNull(newPerson);
        assertEquals(1, person1.getId());
    }

    @Test
    void deletePerson() {
        Adopter person1 = new AdopterImpl("Edwin Soto", "111-222-3333", "edwin.soto@email.com", true);

        Adopter newPerson = adopterService.insertPerson(person1);
        assertNotNull(newPerson);

        boolean isDeleted = adopterService.deletePerson(newPerson.getId());
        assertTrue(isDeleted);
    }

    @Test
    void updatePerson() {
        Adopter person1 = new AdopterImpl("Edwin Soto", "111-222-3333", "edwin.soto@email.com", true);

        Adopter newPerson = adopterService.insertPerson(person1);
        assertNotNull(newPerson);

        // Update Person
        person1.setName("Not Edwin Soto");

        boolean isUpdated = adopterService.updatePerson(person1);

        assertTrue(isUpdated);
    }

    @Test
    void getPerson() {
        Adopter person1 = new AdopterImpl("Edwin Soto", "111-222-3333", "edwin.soto@email.com", true);

        Adopter newPerson = adopterService.insertPerson(person1);
        assertNotNull(newPerson);

        Adopter person = adopterService.getPersonById(1);

        assertEquals("Edwin Soto", person.getName());
    }

    @Test
    void getAllPersons() {

        Adopter person1 = new AdopterImpl("Edwin Soto", "111-222-3333", "edwin.soto@email.com", true);
        Adopter person2 = new AdopterImpl("Yao Ming", "111-222-3333", "yao.ming@email.com", false);
        Adopter person3 = new AdopterImpl("Liam Soto", "111-222-3333", "liam.soto@email.com");

        Adopter newPerson = adopterService.insertPerson(person1);
        adopterService.insertPerson(person2);
        adopterService.insertPerson(person3);

        List<Adopter> persons = adopterService.getAllPersons();

        assertEquals(3, persons.size());
    }

}