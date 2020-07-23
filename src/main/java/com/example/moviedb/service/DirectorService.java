package com.example.moviedb.service;

import com.example.moviedb.model.Director;
import com.example.moviedb.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    private DirectorRepository repository;


    public DirectorService(DirectorRepository repository) {
        this.repository = repository;
    }

    // C
    public Director create(Director d){
        return repository.save(d);
    }
    // R
    public Director getOne(Long id){
        return repository.getOne(id);
    }
    public List<Director> getAll(){
        return repository.findAll();
    }
    // U
    public Director update(Director d){
        return repository.save(d);
    }
    // D
    public void delete(Director d){
        repository.delete(d);
    }

}
