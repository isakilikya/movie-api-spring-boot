package dev.patika.movieapispringboot.movie;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    List<Movie> movieList = new ArrayList<>();

    public Object getMovie(String movieId) {
        if (movieId == null) {
            return movieList;
        }
        try {
            return movieList.stream().filter(element -> element.getId() == Long.parseLong(movieId)).findFirst().get();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public void createMovie(Movie movie) {
        movieList.add(movie);
    }
}
