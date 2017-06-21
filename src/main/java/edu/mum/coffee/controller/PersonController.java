package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Raw on 6/17/2017.
 */
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    PersonController(PersonService personService){
        this.personService=personService;
    }


    @RequestMapping(value = "/person",method = RequestMethod.GET)
    public List<Person> getAllPersons() {
        return personService.getAllPerson();
    }

    @RequestMapping(value = "/person/{id}",method = RequestMethod.GET)
    public Person getPerson(@PathVariable long id) {
        return personService.findById(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/person")
    public void addPerson(@RequestBody Person person) {
        personService.savePerson(person);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/person/{id}")
    public void updatePerson(@RequestBody Person person, @PathVariable long id) {
        person.setId(id);
        personService.savePerson(person);
    }



}
