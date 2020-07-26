package com.example.moviedb.service;

import com.example.moviedb.model.Actor;
import com.example.moviedb.model.Director;
import com.example.moviedb.repository.ActorRepository;
import com.example.moviedb.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    private ActorRepository repository;


    public ActorService(ActorRepository repository) {
        this.repository = repository;
    }

    public Actor save(Actor d){
        return repository.save(d);
    }
    public Actor saveAndFlush(Actor d ) { return repository.saveAndFlush(d); }
    public Actor getOne(Long id){ return repository.findById(id).orElse(null); }
    public Optional<Actor> findById(Long id) { return repository.findById(id);}
    public List<Actor> getAll(){ return repository.findAll(); }
    public void delete(Actor d){ repository.delete(d); }


}
