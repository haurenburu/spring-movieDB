package com.example.moviedb.controller;

import com.example.moviedb.model.Person;
import com.example.moviedb.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public List<Person> listAll() {
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public Person getOne(@PathVariable Long id) { return service.getOne(id);}

    @PostMapping
    public Person insert(@RequestBody Person p) {
        return service.save(p);
    }
}
