package com.example.moviedb.service;

import com.example.moviedb.model.Movie;
import com.example.moviedb.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Movie save(Movie m) {
        return repository.save(m);
    }


    public List<Movie> getAll() { return repository.findAll();}
}
