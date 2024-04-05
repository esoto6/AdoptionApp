package com.expeditors;

import com.expeditors.adopter.AbstractPerson;
import com.expeditors.adopter.Person;
import com.expeditors.animal.Animal;
import com.expeditors.animal.Cat;
import com.expeditors.animal.Dog;
import com.expeditors.animal.Turtle;
import com.expeditors.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class Main {


    public void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    public void run() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AdoptionAppConfig.class);
        context.register(AdoptionAppConfig.class);
        context.getEnvironment().setActiveProfiles("dev");
//        context.register(AdoptionAppConfig.class);
//        context.scan("com.expeditors");
//        context.refresh();

        PersonService personService = context.getBean("personService", PersonService.class);

        Person person1 = new AbstractPerson("Edwin Soto", "843-123-7981", "edwin.soto@email.com", true);
        Person person2 = new AbstractPerson("Mackenzie Soto", "843-123-1111", "mackenzie.soto@email.com", true);
        Person person3 = new AbstractPerson("Liam Soto", "123-123-3456", "liam.soto@email.com");
        Person person4 = new AbstractPerson("Leila Soto", "123-123-3456", "leila.soto@email.com");
        Person person5 = new AbstractPerson("Levi Soto", "123-123-3456", "levi.soto@email.com");

        //Add Persons to service
        personService.insertPerson(person1);
        personService.insertPerson(person2);
        personService.insertPerson(person3);
        personService.insertPerson(person4);
        personService.insertPerson(person5);


//        List<Person> persons = personService.getAllPersons();
//        int sizeListPerson = persons.size();
//        System.out.println(STR."Size Persons List: \{sizeListPerson}");
//        persons.forEach(System.out::println);


        String newline = System.lineSeparator();
        System.out.println(newline);
        System.out.println(STR."\{person1.getName()}, \{person2.getName()}, \{person3.getName()}, \{person4.getName()} and \{person5.getName()} are at the adoption facility");
        System.out.println(newline);


        // Add Animals to be Adopted
        Animal cat = new Cat(1,"Fred", LocalDate.of(2024, 1, 23),  "Siamese");
        Animal dog = new Dog(2, "Spot", LocalDate.of(2023,12,24),  "German Malinois");
        Animal turtle = new Turtle(3, "Slimy", LocalDate.of(2022, 3, 23),  "Yellow Belly Slider");
        Animal cat2 = new Cat(4, "Fido", LocalDate.of(2023, 7, 29), "persian");

        cat.animalGreeting();
        dog.animalGreeting();
        turtle.animalGreeting();
        cat2.animalGreeting();

        System.out.println(newline);

        person1.setAdoptedAnimals(cat);
        person2.setAdoptedAnimals(dog);
        person2.setAdoptedAnimals(turtle);
        System.out.println(newline);

        System.out.println(STR."\{cat.getAnimalName()}'s owner is \{cat.getOwner().getName()}");
        System.out.println(STR."\{dog.getAnimalName()}'s owner is \{dog.getOwner().getName()}");
        System.out.println(STR."\{turtle.getAnimalName()}'s owner is \{turtle.getOwner().getName()}");

        System.out.println(STR."The Cat was adopted on: \{cat.getAdoptedDate()}");
        System.out.println(STR."The Dog was adopted on: \{dog.getAdoptedDate()}");
        System.out.println(STR."The Turtle was adopted on: \{turtle.getAdoptedDate()}");
        System.out.println(newline);

        List<Animal> adoptedAnimals = person1.getAdoptedAnimals();
        for (Animal animal: adoptedAnimals){
            System.out.println(STR."Person 1 has adopted: \{animal.toString()}");
        }

        System.out.println(newline);

        // Get All Persons from Service
        System.out.println("Post Adoptions");
        List<Person> persons = personService.getAllPersons();
        System.out.println(STR."Persons Size: \{persons.size()}");
        persons.forEach(System.out::println);

        // Find Adopter By Name
        String nameToSearch = "Edwin Soto";
        boolean isPerson = personService.getPersonName(nameToSearch);
        System.out.println(STR."Person: \{nameToSearch} is \{isPerson}");

        String nameToSearch2 = "Gracie Soto";
        boolean isPerson2 = personService.getPersonName(nameToSearch2);
        System.out.println(STR."Person: \{nameToSearch2} is \{isPerson2}");


        // Before findAll
        List<Person> personBefore = personService.getAllPersons();
        System.out.println(personBefore);

//        // After naturalSort
//        Collection<Person> personAfter = personService.sortNaturalOrder();
//        System.out.println(personAfter);


    }
}