package com.expeditors.adopter;

import com.expeditors.animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class AdopterImpl implements Adopter {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private boolean isOver18;
    private List<Animal> adoptedAnimals = new ArrayList<>();

    public AdopterImpl(int id, String name, String phoneNumber, String email, Boolean isOver18) {
        this.id = id;
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        this.isOver18 = isOver18;
    }

    public AdopterImpl(String name, String phoneNumber, String email) {
        this(name, phoneNumber, email, false);
    }

    public AdopterImpl(String name, String phoneNumber, String email, Boolean isOver18){
        this(0, name, phoneNumber,email,isOver18);

    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        if (id == 0) {
            throw new IllegalArgumentException("Argument: ID can't be zero or null");
        }
        this.id = id;
    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Argument: name can't be null");
        } else if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Argument: name can't be an empty or blank string");
        }
        this.name = name;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Argument: phoneNumber can't be null");
        } else if (phoneNumber.trim().isEmpty()){
            throw new IllegalArgumentException("Argument: phoneNumber can't be empty or blank string");
        } else if (!phoneNumber.matches("^\\d{3}-\\d{3}-\\d{4}$")) {
            throw new IllegalArgumentException(STR."Bad phone number value: \{phoneNumber}. Expecting (xxx-xxx-xxxx)");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Argument: email can't be null");
        } else if (email.trim().isEmpty()) {
            throw new IllegalArgumentException("Argument: email can't be empty or blank string");
        }

        if(!email.matches(".*@.*")) {
            throw new IllegalArgumentException(STR."Bad email value: \{email}, expecting format: name@domain.com");
        }
        this.email = email;
    }


    @Override
    public List<Animal> getAdoptedAnimals() {
        return this.adoptedAnimals;
    }

    @Override
    public void setAdoptedAnimals(Animal animal) {
        adoptedAnimals.add(animal);
        animal.setOwner(this);
        System.out.println(STR."\{name} has adopted \{animal.getAnimalName()}");

    }

    @Override
    public String toString() {
        return STR."Person{id=\{id}, name='\{name}\{'\''}, phoneNumber='\{phoneNumber}\{'\''}, email='\{email}\{'\''}, isOver18=\{isOver18}, adoptedAnimals=\{adoptedAnimals}\{'}'}";
    }
}
