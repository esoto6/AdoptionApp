package com.edwinsoto.adopter;

import com.edwinsoto.animal.Animal;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;
import java.util.List;

public record Adopter(
        Integer id,
        @NotBlank String name,
        @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$") String phoneNumber,
        @Email String email,
        boolean isOver18,
        LocalDateTime dateCreated,
        LocalDateTime dateModified,
        List<Animal> adopterAnimals

){}
