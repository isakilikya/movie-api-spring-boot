package dev.patika.movieapispringboot.movie.service;

import dev.patika.movieapispringboot.actor.service.Actor;

import java.util.List;

public interface MovieService {

    /*
    List<Actor> actors: Actor list to create new actors.
    List<Long> actorIds: actorIds that exist in database.
     */
    Long create(Movie movie, List<Actor> actors, List<Long> actorIds);

    Movie retrieve(Long id);
}
