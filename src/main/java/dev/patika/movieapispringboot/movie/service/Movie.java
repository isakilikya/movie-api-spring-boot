package dev.patika.movieapispringboot.movie.service;

import dev.patika.movieapispringboot.movie.enums.Genre;
import dev.patika.movieapispringboot.movie.repository.MovieEntity;
import lombok.*;

@Getter
@Builder
@EqualsAndHashCode
public class Movie {
    private Long id;
    private String name;
    private Genre genre;
    private Integer releaseYear;
    private String director;

    MovieEntity convertToMovieEntity() {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(getName());
        movieEntity.setDirector(getDirector());
        movieEntity.setGenre(getGenre());
        movieEntity.setReleaseYear(getReleaseYear());

        return movieEntity;
    }

    public static Movie convertFrom(MovieEntity entity) {
        return Movie.builder()
                .name(entity.getName())
                .director(entity.getDirector())
                .genre(entity.getGenre())
                .releaseYear(entity.getReleaseYear())
                .build();
    }
}
