package com.edwinsoto.animal;

import java.time.LocalDate;

public class Cat extends AnimalImpl {
    public Cat(int id, String name, LocalDate dob, String breed){
        super(id, name, dob, breed);
    }

    @Override
    public void animalGreeting() {
        //return String.format("%s the %s cat meowed gracefully", this.name, this.breed);
        System.out.println(STR."\{this.name} the \{this.breed} cat meowed gracefully");
    }


}
