package dev.patika.movieapispringboot.movie.service;

import dev.patika.movieapispringboot.actor.service.Actor;
import dev.patika.movieapispringboot.movie.controller.MovieResponse;
import dev.patika.movieapispringboot.movie.enums.Genre;
import dev.patika.movieapispringboot.movie.repository.MovieDao;
import dev.patika.movieapispringboot.movie.repository.MovieEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;
    List<Movie> movieList = new ArrayList<>();

    @Override
    public Long create(Movie movie, List<Actor> actors, List<Long> actorIds) {
        final MovieEntity createdMovie = movieDao.save(movie.convertToMovieEntity());
        return createdMovie.getId();
    }

    @Override
    public Movie retrieve(Long id) {
        MovieEntity entity = movieDao.retrieve(id);
        return Movie.convertFrom(entity);
    }
}
