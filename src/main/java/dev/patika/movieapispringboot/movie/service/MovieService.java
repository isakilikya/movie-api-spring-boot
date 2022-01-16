package dev.patika.movieapispringboot.movie.service;

import dev.patika.movieapispringboot.movie.controller.MovieResponse;
import dev.patika.movieapispringboot.movie.enums.Genre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    List<Movie> movieList = new ArrayList<>();

    public Object getMovie(String movieId) {
        Movie dummyMovie = Movie.builder()
                .name("Pulp Fiction")
                .releaseYear(1994)
                .genre(Genre.DRAMA)
                .director("Quentin Tarantino")
                .build();
        return MovieResponse.convertFrom(dummyMovie);
    }

    public void createMovie(Movie movie) {
        movieList.add(movie);
    }
}
