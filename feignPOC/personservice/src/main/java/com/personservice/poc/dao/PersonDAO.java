package com.personservice.poc.dao;

import com.personservice.poc.model.model.PersonModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDAO {

    private List<PersonModel> personModels = new ArrayList<>();

    public PersonDAO() {
        personModels.add(new PersonModel(1,1,"Deivid", 21));
        personModels.add( new PersonModel(2,2,"Maria", 15));
        personModels.add( new PersonModel(3,3,"Joao", 45));
        personModels.add( new PersonModel(4,4,"Daniel", 70));
        personModels.add( new PersonModel(5,3,"Daniel", 70));

    }

    public List<PersonModel> getPersonModels() {
        return personModels;
    }

    public void setPersonModels(List<PersonModel> personModels) {
        this.personModels = personModels;
    }

    public PersonModel getPersonById(int id) {
        return personModels.get(id);
    }


}
