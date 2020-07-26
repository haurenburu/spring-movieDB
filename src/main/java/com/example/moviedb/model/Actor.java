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
public class Actor extends RepresentationModel<Actor> {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer quantMovies;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "person_id")
    Person person;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    List<Movie> movies;

}
