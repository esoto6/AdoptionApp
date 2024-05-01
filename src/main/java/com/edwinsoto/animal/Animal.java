package com.edwinsoto.animal;


import com.edwinsoto.adopter.Adopter;

import java.time.LocalDate;

public interface Animal {
    String getAnimalName();

    LocalDate getAdoptedDate();

    void animalGreeting();

    Adopter getOwner();

    @Override
    String toString();

    void setOwner(Adopter owner);

}
