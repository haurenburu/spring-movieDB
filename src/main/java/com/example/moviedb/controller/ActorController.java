package com.example.moviedb.controller;

import com.example.moviedb.model.Actor;
import com.example.moviedb.service.ActorService;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping("/actor")
public class ActorController {
    private ActorService service;

    public ActorController(ActorService service) { this.service = service; }

    @GetMapping
    public List<Actor> listAll() {
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Actor> getOne(@PathVariable Long id) {
/*
        Optional<Actor> actorOptional = service.findById(id);

        if(actorOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Actor actor = actorOptional.get();
            // self
            actor.add(WebMvcLinkBuilder.linkTo(ActorController.class).slash(id).withSelfRel());
            // all
            actor.add(WebMvcLinkBuilder.linkTo(ActorController.class).withRel("all-actor"));

            return ResponseEntity.ok().body(actor);
        }
*/
        return service.findById(id)
                .map( re -> {
                    return ResponseEntity.ok().body(re);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Actor create(@RequestBody Actor d) {
        return service.save(d);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Actor> update(@PathVariable Long id, @RequestBody Actor d) {
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
