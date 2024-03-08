package com.group.Addressapp.controller;

import com.group.Addressapp.PersonService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v2")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public void savePerson() {
        personService.savePerson();
    }
}
