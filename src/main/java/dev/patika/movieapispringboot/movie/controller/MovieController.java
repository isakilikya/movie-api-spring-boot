package dev.patika.movieapispringboot.movie.controller;

import dev.patika.movieapispringboot.movie.service.Movie;
import dev.patika.movieapispringboot.movie.service.MovieService;
import dev.patika.movieapispringboot.movie.service.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/movie")
public class MovieController {

    private final MovieService service;

    @GetMapping
    public Object retrieve(@RequestParam Long movieId) {
        return service.retrieve(movieId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Object create(@RequestBody MovieRequest request) {
        try {
            Movie movie = request.convertToMovie();
            return service.create(movie, null, null);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
