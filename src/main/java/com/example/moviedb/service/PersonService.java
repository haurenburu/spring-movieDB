package com.example.moviedb.service;

import com.example.moviedb.model.Person;
import com.example.moviedb.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person save(Person p) { return repository.save(p);}
    public Person saveAndFlush(Person p) { return repository.saveAndFlush(p);}
    public Person getOne(Long id) { return repository.findById(id).orElse(null);}
    public Optional<Person> findById(Long id) { return repository.findById(id);}
    public List<Person> getAll() { return repository.findAll();}
    public void delete(Person p) { repository.delete(p);}

}
