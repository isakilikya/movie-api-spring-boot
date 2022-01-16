package dev.patika.movieapispringboot.movie.service;

import dev.patika.movieapispringboot.movie.enums.Genre;
import lombok.*;

@Getter
@Builder
@EqualsAndHashCode
public class Movie {
    private String name;
    private Genre genre;
    private Integer releaseYear;
    private String director;
}
