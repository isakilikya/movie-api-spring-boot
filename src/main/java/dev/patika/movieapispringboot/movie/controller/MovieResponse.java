package dev.patika.movieapispringboot.movie.controller;

import dev.patika.movieapispringboot.actor.service.Actor;
import dev.patika.movieapispringboot.movie.enums.Genre;
import dev.patika.movieapispringboot.movie.service.Movie;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MovieResponse {
    private Long id;
    private String name;
    private Genre genre;
    private Integer releaseYear;
    private String director;
    private List<Actor> cast;

    public static MovieResponse convertFrom(Movie movie) {
        return MovieResponse.builder()
                .id(movie.getId())
                .name(movie.getName())
                .genre(movie.getGenre())
                .releaseYear(movie.getReleaseYear())
                .director(movie.getDirector())
                .build();
    }
}
