package com.edwinsoto.service;

import com.edwinsoto.adopter.Adopter;
import com.edwinsoto.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdopterService {

//    @Autowired
    private PersonDAO personDAO;

    @Autowired
    public AdopterService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public Adopter insertPerson(Adopter person){
        return personDAO.insert(person);
    }


    public boolean deletePerson(int id){
        return personDAO.delete(id);
    }


    public boolean updatePerson(Adopter person) {
        return personDAO.update(person);
    }


    public Adopter getPerson(int id){
        return personDAO.findByID(id);
    }


    public boolean getPersonName(String name){
        return personDAO.findByName(name);
    }


    public List<Adopter> getAllPersons(){
        return personDAO.findAll();
    }

}


