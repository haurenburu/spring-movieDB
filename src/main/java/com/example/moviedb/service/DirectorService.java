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
    public Director save(Director d){
        return repository.save(d);
    }
    public Director getOne(Long id){ return repository.getOne(id); }
    public List<Director> getAll(){
        return repository.findAll();
    }
    public void delete(Director d){
        repository.delete(d);
    }

}
