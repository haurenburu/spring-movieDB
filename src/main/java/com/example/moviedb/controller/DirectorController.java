package com.example.moviedb.controller;

import com.example.moviedb.model.Director;
import com.example.moviedb.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorController {
    private DirectorService service;

    public DirectorController(DirectorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Director> listAll() {
        return service.getAll();
    }
    @PostMapping
    public Director create(@RequestBody Director d) {
        return service.save(d);
    }
}
