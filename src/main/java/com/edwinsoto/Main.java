package com.edwinsoto;

import com.edwinsoto.adopter.AdopterImpl;
import com.edwinsoto.adopter.Adopter;
import com.edwinsoto.animal.Animal;
import com.edwinsoto.animal.Cat;
import com.edwinsoto.animal.Dog;
import com.edwinsoto.animal.Turtle;
import com.edwinsoto.adopter.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Profile("!test")
    @Component
    class MyRunner implements CommandLineRunner {

        @Autowired
        private AdopterService adopterService;

        @Override
        public void run(String... args) throws Exception {
            System.out.println("MyRunner has been called");

            Adopter person1 = new AdopterImpl("Edwin Soto", "111-111-1111", "edwin.soto@email.com", true);
            Adopter person2 = new AdopterImpl("Mackenzie Soto", "222-222-2222", "mackenzie.soto@email.com", true);
            Adopter person3 = new AdopterImpl("Liam Soto", "333-333-3333", "liam.soto@email.com");
            Adopter person4 = new AdopterImpl("Leila Soto", "444-444-4444", "leila.soto@email.com");
            Adopter person5 = new AdopterImpl("Levi Soto", "555-555-5555", "levi.soto@email.com");

            //Add Persons to service
            adopterService.insertPerson(person1);
            adopterService.insertPerson(person2);
            adopterService.insertPerson(person3);
            adopterService.insertPerson(person4);
            adopterService.insertPerson(person5);


            List<Adopter> persons = adopterService.getAllPersons();
            int sizeListPerson = persons.size();
            System.out.println("All Adopters:");
            System.out.println(STR."Size of Persons List: \{sizeListPerson}");
            persons.forEach(System.out::println);

            String newline = System.lineSeparator();
            System.out.println(newline);
            System.out.println(STR."\{person1.getName()}, \{person2.getName()}, \{person3.getName()}, \{person4.getName()} and \{person5.getName()} are at the adoption facility");

            // Add Animals to be Adopted
            Animal cat = new Cat(1,"Fred", LocalDate.of(2024, 1, 23),  "Siamese");
            Animal cat2 = new Cat(4, "Fido", LocalDate.of(2023, 7, 29), "persian");
            Animal dog = new Dog(3, "Gracie", LocalDate.of(2022, 1, 23), "Terrier Mix");
            Animal dog2 = new Dog(2, "Spot", LocalDate.of(2023,12,24),  "German Malinois");
            Animal turtle = new Turtle(3, "Slimy", LocalDate.of(2022, 3, 23),  "Yellow Belly Slider");

//            // Animals make greetings
//            System.out.println();
//            cat.animalGreeting();
//            cat2.animalGreeting();
//            dog.animalGreeting();
//            dog2.animalGreeting();
//            turtle.animalGreeting();
//
//            // Set Adopted Animals
//            System.out.println(newline);
//            person1.setAdoptedAnimals(dog);
//            person2.setAdoptedAnimals(cat);
//            person2.setAdoptedAnimals(turtle);
//
//            // Get Owners of Adopted Animals
//            System.out.println(newline);
//            System.out.println(STR."\{dog.getAnimalName()}'s owner is \{dog.getOwner().getName()} adopted on \{dog.getAdoptedDate()}.");
//            System.out.println(STR."\{cat.getAnimalName()}'s owner is \{cat.getOwner().getName()} adopted on \\{dog.getAdoptedDate()}.");
//            System.out.println(STR."\{turtle.getAnimalName()}'s owner is \{turtle.getOwner().getName()} adopted on \\{dog.getAdoptedDate()}.");
//
//            System.out.println(newline);
//            System.out.println("Adopted Animals for Person2");
//            List<Animal> adoptedAnimals = person2.getAdoptedAnimals();
//            for (Animal animal: adoptedAnimals){
//                System.out.println(STR."Person 2 has adopted: \{animal.toString()}");
//            }
//
//            // Get All Persons from Service
//            System.out.println(newline);
//            System.out.println("Post Adoptions");
//            persons = adopterService.getAllPersons();
//            System.out.println(STR."Persons Size: \{persons.size()}");
//            persons.forEach(System.out::println);
//
//            // Find Adopter By Name
//            System.out.println(newline);
//            String nameToSearch = "Edwin Soto";
//            boolean isPerson = adopterService.getPersonName(nameToSearch);
//            System.out.println(STR."Person: \{nameToSearch} is \{isPerson}");
//
//            String nameToSearch2 = "Gracie Soto";
//            boolean isPerson2 = adopterService.getPersonName(nameToSearch2);
//            System.out.println(STR."Person: \{nameToSearch2} is \{isPerson2}");
        }
    }
}
