package dev.patika.movieapispringboot.movie;

import dev.patika.movieapispringboot.movie.enums.Genre;
import dev.patika.movieapispringboot.movie.service.Movie;
import dev.patika.movieapispringboot.movie.service.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MovieServiceTest {

    @Autowired
    MovieServiceImpl underTest;

    @Test
    void it_should_add_new_movie_successfully() {
        // given
        Movie movie = Movie.builder()
                .name("Pulp Fiction")
                .genre(Genre.DRAMA)
                .releaseYear(1994)
                .director("Quentin Tarantino")
                .build();
        // when
        final Long movieId = underTest.create(movie, null, null);
        // then
        final Movie result = underTest.retrieve(movieId);
        assertThat(result.getName()).isEqualTo(movie.getName());
    }

    @Test
    void it_should_throw_exception_while_adding_new_movie_because_of_null_name() {
        // given
        Movie movie = Movie.builder()
                .name(null)
                .genre(Genre.DRAMA)
                .releaseYear(1994)
                .director("Quentin Tarantino")
                .build();

        Exception exception = null;
        // when
        try {
            underTest.create(movie, null, null);
        } catch (Exception e) {
            exception = e;
        }
        // then
        assertThat(exception).isNotNull();
    }

    @Test
    void it_should_throw_exception_while_retrieving_a_movie_because_it_doesnt_exist() {
        // given
        Exception exception = null;
        Long randomNumber = 1234567L;
        // when
        try {
            final Movie retrieve = underTest.retrieve(randomNumber);
        } catch (Exception e) {
            exception = e;
        }
        // then
        assertThat(exception).isNotNull();
    }
}
