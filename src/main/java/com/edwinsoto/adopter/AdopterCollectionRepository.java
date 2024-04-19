package com.edwinsoto.adopter;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("dev")
public class AdopterCollectionRepository {

    private final List<Adopter> adopters = new ArrayList<>();
    private int nextId =1;

    public AdopterCollectionRepository() {}



    public List<Adopter> findAll(){
        return adopters;
    }

    public Optional<Adopter> findById(int id){
        return adopters.stream().filter(a -> a.id().equals(id)).findFirst();
    }


    public void insertAdopter(Adopter adopter) {
        Integer id = adopter.id();
        if (id == null || id == 0) {
            Adopter updatedAdopter = new Adopter(nextId++, adopter.name(), adopter.phoneNumber(), adopter.email(), adopter.isOver18(), LocalDateTime.now(), null, adopter.adopterAnimals());
            adopters.add(updatedAdopter);
        }
        else {
            Adopter updatedAdopter = new Adopter(adopter.id(), adopter.name(), adopter.phoneNumber(), adopter.email(), adopter.isOver18(), adopter.dateCreated(), LocalDateTime.now(), adopter.adopterAnimals());
            delete(adopter.id());
            adopters.add(updatedAdopter);
        }

    }

    public boolean existsById(Integer id) {
        return adopters.stream().anyMatch(a -> a.id().equals(id));
    }

    public void delete(Integer id) {
        adopters.removeIf(a -> a.id().equals(id));
    }

    @PostConstruct
    public void init(){
        // Use the PostConstruct to init the adopters
        Adopter person1 = new Adopter(nextId++, "Edwin Soto", "111-111-1111", "edwin.soto@email.com", true, LocalDateTime.now(), null, null);
        Adopter person2 = new Adopter(nextId++, "Mackenzie Soto", "222-222-2222", "mackenzie.soto@email.com", true, LocalDateTime.now(), null, null);
        Adopter person3 = new Adopter(nextId++, "Liam Soto", "333-333-3333", "liam.soto@email.com", false, LocalDateTime.now(), null, null);
        Adopter person4 = new Adopter(nextId++, "Leila Soto", "444-444-4444", "leila.soto@email.com", false, LocalDateTime.now(), null, null);
        Adopter person5 = new Adopter(nextId++, "Levi Soto", "555-555-5555", "levi.soto@email.com", false, LocalDateTime.now(), null, null);

        adopters.add(person1);
        adopters.add(person2);
        adopters.add(person3);
        adopters.add(person4);
        adopters.add(person5);
    }


}
