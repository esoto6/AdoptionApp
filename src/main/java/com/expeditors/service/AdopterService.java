package com.expeditors.service;

import com.expeditors.adopter.Adopter;
import com.expeditors.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personService")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AdopterService {

    @Autowired
    private PersonDAO personDAO;

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


