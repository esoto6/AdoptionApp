package com.edwinsoto.adopter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AdopterServiceTest {

    @Autowired
    private AdopterService adopterService;

    @Test
    void testGetAllAdopters() {
        assertNotNull(adopterService.getAllAdopters());
    }

    @Test
    void testgetValidAdopterById() {
        assertNotNull(adopterService.getAdopterById(1));
    }

    @Test
    void testgetInValidAdopterById() {
        assertEquals(Optional.empty(), adopterService.getAdopterById(100));
    }

    @Test
    void testValidinsertAdopter() {
        Adopter newAdopter = new Adopter(null, "Barnie Rubble", "111-111-1111", "barnie.rubble@email.com", true, LocalDateTime.now(), null, null);
        adopterService.insertAdopter(newAdopter);

        List<Adopter> adopters = adopterService.getAllAdopters();
        assertEquals(6, adopters.size());
    }

    @Test
    void testUpdateAdopter() {
        Adopter newAdopter = new Adopter(1, "Barnie Rubble", "111-111-1111", "barnie.rubble@email.com", true, LocalDateTime.now(), null, null);
        adopterService.insertAdopter(newAdopter);
        Optional<Adopter> adopter = adopterService.getAdopterById(1);
        assertTrue(adopter.isPresent());
        assertEquals("Barnie Rubble", adopter.get().name());
    }

    @Test
    void testValidexistsById() {
        boolean exists = adopterService.existsById(1);
        assertTrue(exists);
    }

    @Test
    void testInvalidexistsById() {
        boolean exists = adopterService.existsById(100);
        assertFalse(exists);
    }

    @Test
    void deleteAdopterById() {
        adopterService.deleteAdopterById(1);
        assertTrue(adopterService.getAllAdopters().size() == 4);
    }
}