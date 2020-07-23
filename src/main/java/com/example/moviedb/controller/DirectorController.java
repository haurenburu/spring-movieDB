package com.example.moviedb.controller;

import com.example.moviedb.model.Director;
import com.example.moviedb.repository.DirectorRepository;
import com.example.moviedb.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/director")
public class DirectorController {
    private DirectorService service;
    private DirectorRepository repository;

    public DirectorController(DirectorService service) { this.service = service; }

    @GetMapping
    public List<Director> listAll() {
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Director> getOne(@PathVariable Long id) {

        return service.findById(id)
                .map( re -> ResponseEntity.ok().body(re))
                .orElse(ResponseEntity.notFound().build());

        /*
        Optional<Director> optional = service.findById(id);

        if(optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
        */
    }

    @PostMapping
    public Director create(@RequestBody Director d) {
        return service.save(d);
    }

    @PutMapping(value = "/{id}")
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
