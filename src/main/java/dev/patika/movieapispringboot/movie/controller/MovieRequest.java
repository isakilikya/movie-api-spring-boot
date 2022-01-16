package dev.patika.movieapispringboot.movie.controller;

import dev.patika.movieapispringboot.actor.service.Actor;
import dev.patika.movieapispringboot.movie.enums.Genre;
import dev.patika.movieapispringboot.movie.service.Movie;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class MovieRequest {

    private String name;
    private Genre genre;
    private Integer releaseYear;
    private String director;
    private List<Actor> cast;

    public Movie convertToMovie() {
        return Movie.builder()
                .name(name)
                .genre(genre)
                .releaseYear(releaseYear)
                .director(director)
                .build();
    }
}
