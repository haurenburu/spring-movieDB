package com.example.moviedb.controller;

import ch.qos.logback.core.net.server.Client;
import com.example.moviedb.model.Director;
import com.example.moviedb.service.DirectorService;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/director")
public class DirectorController {
    private DirectorService service;

    public DirectorController(DirectorService service) { this.service = service; }

    @CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
    @GetMapping
    public List<Director> listAll() {
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Director> getOne(@PathVariable Long id) {
        Optional<Director> directorOptional = service.findById(id);

        if(directorOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Director director = directorOptional.get();
            // self
            director.add(WebMvcLinkBuilder.linkTo(DirectorController.class).slash(id).withSelfRel());
            // all
            director.add(WebMvcLinkBuilder.linkTo(DirectorController.class).withRel("all-directors"));

            return ResponseEntity.ok().body(director);
        }
/*
        return service.findById(id)
                .map( re -> {
                    return ResponseEntity.ok().body(re);
                }).orElse(ResponseEntity.notFound().build());
*/
    }

    @PostMapping
    public Director create(@RequestBody Director d) {
        return service.save(d);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Director> update(@PathVariable Long id, @RequestBody Director d) {
        return service.findById(id).map( re -> {
            service.saveAndFlush(d);
            return ResponseEntity.ok().body(d);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service.findById(id).map(re -> {
            service.delete(re);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
