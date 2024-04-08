package com.expeditors.animal;

import com.expeditors.adopter.AdopterImpl;

import java.time.LocalDate;

public interface Animal {
    String getAnimalName();

    LocalDate getAdoptedDate();

    void animalGreeting();

    AdopterImpl getOwner();

    @Override
    String toString();

    void setOwner(AdopterImpl owner);

}
