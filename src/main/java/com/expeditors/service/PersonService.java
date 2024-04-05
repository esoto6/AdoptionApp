package com.expeditors.service;

import com.expeditors.adopter.Person;
import com.expeditors.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service("personService")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class PersonService {

    private PersonDAO personDAO;

    @Autowired
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO; }


    public Person insertPerson(Person person){
        return personDAO.insert(person);
    }


    public boolean deletePerson(int id){
        return personDAO.delete(id);
    }


    public boolean updatePerson(Person person) {
        return personDAO.update(person);
    }


    public Person getPerson(int id){
        return personDAO.findByID(id);
    }


    public boolean getPersonName(String name){
        return personDAO.findByName(name);
    }


    public Collection<Person> sortNaturalOrder() {return personDAO.naturalSort(); }

    public List<Person> getAllPersons(){
        return personDAO.findAll();
    }

}


