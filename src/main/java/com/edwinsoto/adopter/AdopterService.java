package com.edwinsoto.adopter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AdopterService {

    private final AdopterCollectionRepository repository;

    @Autowired
    public AdopterService(AdopterCollectionRepository repository) {
        this.repository = repository;
    }

    public List<Adopter> getAllAdopters(){
        return repository.findAll();
    }

    public Optional<Adopter> getAdopterById(int id) {
        boolean isValidId = repository.existsById(id);
        if (isValidId) {
            return repository.findById(id);
        }
        return Optional.empty();
    }

    public void insertAdopter(Adopter adopter) {
        repository.insertAdopter(adopter);
    }

    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    public void deleteAdopterById(int id) {
        repository.delete(id);
    }

}

