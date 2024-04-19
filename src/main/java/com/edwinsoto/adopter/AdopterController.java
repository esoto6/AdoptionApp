package com.edwinsoto.adopter;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/adopter")
@CrossOrigin()
public class AdopterController {

    private final AdopterService service;

    @Autowired
    public AdopterController(AdopterService adopterService) {
        this.service = adopterService;
    }

    @GetMapping
    public List<Adopter> getAll() {
        return service.getAllAdopters();
    }

    @GetMapping("/id={id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<Adopter> person = service.getAdopterById(id);
        if (person.isPresent()){
            return ResponseEntity.ok().body(person.get());
        }
        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void addPerson(@Valid @RequestBody Adopter adopter) {
        service.insertAdopter(adopter);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/id={id}")
    public void update(@Valid @RequestBody Adopter adopter, @PathVariable Integer id) {
        if(!service.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, STR."Adopter \{id} not found");
        }
        service.insertAdopter(adopter);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/id={id}")
    public void deleteById(@PathVariable int id) {
        if (!service.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, STR."Adopter \{id} not found");
        }
        service.deleteAdopterById(id);
    }
}
