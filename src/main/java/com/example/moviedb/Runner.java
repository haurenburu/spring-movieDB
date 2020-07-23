package com.example.moviedb;

import com.example.moviedb.model.Director;
import com.example.moviedb.model.Movie;
import com.example.moviedb.model.Person;
import com.example.moviedb.repository.DirectorRepository;
import com.example.moviedb.repository.MovieRepository;
import com.example.moviedb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Component
public class Runner implements ApplicationRunner {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    MovieRepository movieRepository;

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
//        Person p = new Person();
//        p.setFirstName("fn");
//        p.setLastName("ln");
//        personRepository.save(p);
//        Director d = new Director();
//        d.setQuantMovies(20);
//        d.setPerson(p);
//
//        Movie m1 = new Movie();
//        Movie m2 = new Movie();
//        Movie m3 = new Movie();
//        m1.setTitle("m1");
//        m2.setTitle("m2");
//        m3.setTitle("m3");
//        m1.setDuration(29);
//        m2.setDuration(29);
//        m3.setDuration(29);
//        movieRepository.save(m1);
//        movieRepository.save(m2);
//        movieRepository.save(m3);
//
//        List<Movie> list = Arrays.asList(m1,m2,m3);
//
//        d.setMovies(list);
//
//        directorRepository.save(d);
    }
}
