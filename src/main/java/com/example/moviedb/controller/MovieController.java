package com.example.moviedb.controller;

import com.example.moviedb.model.Movie;
import com.example.moviedb.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping("/movie")
public class MovieController {
    private MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Movie> listAll() { return service.getAll();}

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Movie> getOne(@PathVariable Long id) {
        return service.findById(id)
                .map( re -> {
                    return ResponseEntity.ok().body(re);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Movie create(@RequestBody Movie m) {
        return service.save(m);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Movie> update(@PathVariable Long id, @RequestBody Movie m) {
        return service.findById(id).map( re -> {
            service.saveAndFlush(m);
            return ResponseEntity.ok().body(m);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.findById(id).map( re -> {
            service.delete(re);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
