package com.personservice.poc;

import com.personservice.poc.model.contract.PersonContract;
import com.personservice.poc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("person/v1")
public class Endpoint {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonContract> getAllPersonModels() throws IOException {
        return personService.getAllPersons();
    }

    @RequestMapping(value = "/{personId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonContract getPersonById(@PathVariable(value = "personId") int personId){
        return personService.getPersonById(personId);
    }


}
