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
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AdopterCollectionRepositoryTest {

    @Autowired
    private AdopterCollectionRepository adopterCollectionRepository;


    @Test
    void testfindAll() {
        List<Adopter> adopters = adopterCollectionRepository.findAll();
        assertEquals(5, adopters.size());
    }

    @Test
    void testFindValidID() {
        Optional<Adopter> adopter = adopterCollectionRepository.findById(1);
        assertTrue(adopter.isPresent());
    }

    @Test
    void testFindInvalidID() {
        Optional<Adopter> adopter = adopterCollectionRepository.findById(100);
        assertFalse(adopter.isPresent());
    }

    @Test
    void testinsertNewAdopter() {
        Adopter newAdopter = new Adopter(null, "Barnie Rubble", "111-111-1111", "barnie.rubble@email.com", true, LocalDateTime.now(), null, null);
        adopterCollectionRepository.insertAdopter(newAdopter);

        List<Adopter> adopters = adopterCollectionRepository.findAll();
        assertEquals(6, adopters.size());
    }

    @Test
    void testUpdateAdopter() {
        Adopter newAdopter = new Adopter(1, "Barnie Rubble", "111-111-1111", "barnie.rubble@email.com", true, LocalDateTime.now(), null, null);
        adopterCollectionRepository.insertAdopter(newAdopter);
        Optional<Adopter> adopter = adopterCollectionRepository.findById(1);
        assertTrue(adopter.isPresent());
        assertEquals("Barnie Rubble", adopter.get().name());
    }

    @Test
    void testValidexistsById() {
        boolean exists = adopterCollectionRepository.existsById(1);
        assertTrue(exists);
    }

    @Test
    void testInvalidexistsById() {
        boolean exists = adopterCollectionRepository.existsById(100);
        assertFalse(exists);
    }

    @Test
    void testValidDelete() {
        List<Adopter> adopters = adopterCollectionRepository.findAll();
        assertEquals(5, adopters.size());

        adopterCollectionRepository.delete(1);
        adopters = adopterCollectionRepository.findAll();
        assertEquals(4, adopters.size());
    }

    @Test
    void testInValidDelete() {
        List<Adopter> adopters = adopterCollectionRepository.findAll();
        assertEquals(5, adopters.size());

        adopterCollectionRepository.delete(100);
        adopters = adopterCollectionRepository.findAll();
        assertEquals(5, adopters.size());
    }

    @Test
    void init() {
        List<Adopter> adopters = adopterCollectionRepository.findAll();
        assertEquals(5, adopters.size());
    }
}