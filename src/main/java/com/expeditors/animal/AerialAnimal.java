package com.expeditors.animal;

import com.expeditors.adopter.AbstractPerson;

import java.time.LocalDate;

public class AerialAnimal implements Animal {

    @Override
    public String getAnimalName() {
        return null;
    }

    @Override
    public LocalDate getAdoptedDate() {
        return null;
    }

    @Override
    public void animalGreeting() {

    }

    @Override
    public AbstractPerson getOwner() {
        return null;
    }

    @Override
    public void setOwner(AbstractPerson owner) {

    }
}
