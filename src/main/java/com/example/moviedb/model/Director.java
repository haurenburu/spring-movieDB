package com.example.moviedb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Director extends RepresentationModel<Director> {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer quantMovies;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    List<Movie> movies;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "person_id")
    Person person;

}
