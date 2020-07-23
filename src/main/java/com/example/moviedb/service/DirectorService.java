package com.example.moviedb.service;

import com.example.moviedb.model.Director;
import com.example.moviedb.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    private DirectorRepository repository;


    public DirectorService(DirectorRepository repository) {
        this.repository = repository;
    }

    public Director save(Director d){
        return repository.save(d);
    }
    public Director saveAndFlush(Director d ) { return repository.saveAndFlush(d); }
    public Director getOne(Long id){ return repository.findById(id).orElse(null); }
    public Optional<Director> findById(Long id) { return repository.findById(id);}
    public List<Director> getAll(){ return repository.findAll(); }
    public void delete(Director d){ repository.delete(d); }


}
