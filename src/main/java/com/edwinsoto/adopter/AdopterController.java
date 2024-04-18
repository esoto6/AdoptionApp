package com.edwinsoto.adopter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adopter")
public class AdopterController {

    private AdopterService adopterService;

    @Autowired
    public AdopterController(AdopterService adopterService) {
        this.adopterService = adopterService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAdopters() {
        List<Adopter> adoptersList = adopterService.getAllPersons();
        if (adoptersList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(adoptersList);
    }

    @GetMapping("/id={id}")
    public ResponseEntity<?> getAdopterById(@PathVariable int id) {

        Adopter person = adopterService.getPersonById(id);
        if (person == null) {
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(person);
    }

///   TODO: Finish this
    @PostMapping
    public ResponseEntity<?> addAdopter(@Validated @RequestBody Adopter adopter) {
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/id={id}")
    public ResponseEntity<?> deleteAdopter(@PathVariable int id) {
        boolean deleted = adopterService.deletePerson(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

//    TODO: Finish this
    @PutMapping
    public ResponseEntity<?> updateAdopter(@RequestBody Adopter person) {
        boolean updated = adopterService.updatePerson(person);
        if (updated) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
