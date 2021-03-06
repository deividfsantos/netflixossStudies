package com.personservice.poc.service;

import com.personservice.poc.connector.AddressServiceConnector;
import com.personservice.poc.dao.PersonDAO;
import com.personservice.poc.model.model.AddressModel;
import com.personservice.poc.model.contract.PersonContract;
import com.personservice.poc.model.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    PersonDAO personDAO;

    public List<PersonContract> getAllPersons(){
        return personDAO
                .getPersonModels()
                .stream()
                .map(personModel -> getPersonContract(personModel))
                .collect(Collectors.toList());
    }

    public PersonContract getPersonById(int id) {
        PersonModel personModel = personDAO.getPersonById(id-1);
        PersonContract personContract = getPersonContract(personModel);

        return personContract;
    }

    private PersonContract getPersonContract(PersonModel personModel) {

        AddressServiceConnector addressServiceConnector = new AddressServiceConnector();
        AddressModel addressModel = addressServiceConnector.run().findAddressById(personModel.getAddressId());

        return new PersonContract(addressModel, personModel.getName(),personModel.getAge());
    }
}
