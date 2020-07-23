package com.example.moviedb;

import com.example.moviedb.model.Director;
import com.example.moviedb.model.Person;
import com.example.moviedb.repository.DirectorRepository;
import com.example.moviedb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class Runner implements ApplicationRunner {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    DirectorRepository directorRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
//        Person p = new Person();
//        Director d = new Director();
//        p.setFirstName("first");
//        p.setLastName("last");
//        d.setQuantMovies(5);
//
//        personRepository.save(p);
//        p.setDirector(d);
//        d.setPerson(p);
//        directorRepository.save(d);
    }
}
