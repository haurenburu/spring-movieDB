package com.example.moviedb.controller;

import com.example.moviedb.model.Person;
import com.example.moviedb.service.PersonService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Person> getOne(@PathVariable Long id) {
        return service.findById(id)
                .map( re -> {
                    return ResponseEntity.ok().body(re);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Person create(@RequestBody Person p) {
        return service.save(p);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person p) {
        return service.findById(id).map( re -> {
            service.saveAndFlush(p);
            return ResponseEntity.ok().body(p);
        }).orElse(ResponseEntity.notFound().build());
    }
// I DON'T WANT TO DELETE A PERSON ASSOCIATED TO A DIRECTOR
/*
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.findById(id).map( re -> {
            service.delete(re);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
*/
}
