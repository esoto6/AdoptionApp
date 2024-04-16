package com.edwinsoto.adopter;

import com.edwinsoto.animal.Animal;

import java.util.List;

public interface Adopter {
    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    String getEmail();

    void setEmail(String email);

    List<Animal> getAdoptedAnimals();

    void setAdoptedAnimals(Animal animal);


    @Override
    String toString();
}
