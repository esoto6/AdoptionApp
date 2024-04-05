package com.expeditors.animal;

import com.expeditors.adopter.AbstractPerson;
import com.expeditors.adopter.Person;

import java.time.LocalDate;

public interface Animal {
    String getAnimalName();

    LocalDate getAdoptedDate();

    void animalGreeting();

    AbstractPerson getOwner();

    @Override
    String toString();

    void setOwner(AbstractPerson owner);

}
