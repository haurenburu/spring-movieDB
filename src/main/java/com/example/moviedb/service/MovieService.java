package com.example.moviedb.service;

import com.example.moviedb.model.Movie;
import com.example.moviedb.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Movie save(Movie m) { return repository.save(m); }
    public Movie saveAndFlush(Movie m) { return repository.saveAndFlush(m);}
    public Movie getOne(Long id) { return repository.getOne(id);}
    public Optional<Movie> findById(Long id) { return repository.findById(id); }
    public List<Movie> getAll() { return repository.findAll();}
    public void delete(Movie m) { repository.delete(m);}
}
