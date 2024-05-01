package com.edwinsoto.animal;


import com.edwinsoto.adopter.Adopter;

import java.time.LocalDate;

public class AnimalImpl implements Animal {

    protected int id;
    protected String name;
    protected LocalDate dob;
    protected String breed;
    protected Adopter owner;
    protected LocalDate adoptedDate;

    public AnimalImpl(int id, String name, LocalDate dob, String breed) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.breed = breed;
    }

    @Override
    public String getAnimalName() {
        return this.name;
    }

    @Override
    public LocalDate getAdoptedDate(){
        return this.adoptedDate;
    }

    @Override
    public void animalGreeting(){
        System.out.println("The animal moved");
    }

    @Override
    public Adopter getOwner(){
        return owner;
    }

//    @Override
//    public String toString() {
//        return STR."Animal{id=\{id}, name='\{name}\{'\''}, dob=\{dob}, breed='\{breed}\{'\''}, owner=\{getOwner().getName()}, adoptedDate=\{adoptedDate}\{'}'}";
//    }

    public void setOwner(Adopter owner) {
        this.adoptedDate = LocalDate.now();
        this.owner = owner;
    }


}
