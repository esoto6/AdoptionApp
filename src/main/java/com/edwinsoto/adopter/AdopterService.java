package com.edwinsoto.adopter;

import com.edwinsoto.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdopterService {

    private PersonDAO personDAO;

    @Autowired
    public AdopterService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public Adopter insertPerson(Adopter person){
        return personDAO.insert(person);
    }

    public boolean updatePerson(Adopter person) {
        return personDAO.update(person);
    }

    public boolean deletePerson(int id){
        return personDAO.delete(id);
    }

    public Adopter getPersonById(int id){
        return personDAO.findByID(id);
    }


    public List<Adopter> getAllPersons(){
        return personDAO.findAll();
    }


}


