package com.edwinsoto.animal;

import java.time.LocalDate;

public class Dog extends AnimalImpl {
    public Dog(int id, String name, LocalDate dob, String breed) {
        super(id, name, dob, breed);
    }
    @Override
    public void animalGreeting() {
        //return String.format("%s the %s dog barked gracefully", this.name, this.breed);
        System.out.println(STR."\{this.name} the \{this.breed} barked at Lokesh");
    }
}
