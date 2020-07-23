package com.example.moviedb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer quantMovies;

    @OneToMany(cascade = CascadeType.ALL)
    List<Movie> movies;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "person_id")
    Person person;



}
