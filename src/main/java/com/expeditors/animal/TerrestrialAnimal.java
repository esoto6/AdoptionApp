package com.expeditors.animal;

import com.expeditors.adopter.AdopterImpl;

import java.time.LocalDate;

public class TerrestrialAnimal implements Animal {

    protected int id;
    protected String name;
    protected LocalDate dob;
    protected String breed;
    protected AdopterImpl owner;
    protected LocalDate adoptedDate;

    public TerrestrialAnimal(int id, String name, LocalDate dob, String breed) {
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
    public AdopterImpl getOwner(){
        return owner;
    }

    @Override
    public String toString() {
        return STR."Animal{id=\{id}, name='\{name}\{'\''}, dob=\{dob}, breed='\{breed}\{'\''}, owner=\{getOwner().getName()}, adoptedDate=\{adoptedDate}\{'}'}";
    }

    public void setOwner(AdopterImpl owner) {
        this.adoptedDate = LocalDate.now();
        this.owner = owner;
    }


}
