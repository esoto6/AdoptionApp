package com.edwinsoto.animal;

import java.time.LocalDate;

public class Turtle extends AnimalImpl {
    public Turtle(int id, String name, LocalDate dob, String breed){
        super(id, name, dob, breed);
    }
    @Override
    public void animalGreeting () {
        //return String.format("%s the %s turtle splashed gracefully", this.name, this.breed);
        System.out.println(STR."\{this.name} the \{this.breed} turtle splashed sporadically");
    }


}