package pl.konmarek.firstspringexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.konmarek.firstspringexample.domain.Person;
import pl.konmarek.firstspringexample.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // /person/all
    @GetMapping("/all")
    List<Person> allPersons() {
        return personService.findAllPersons();
    }
}
