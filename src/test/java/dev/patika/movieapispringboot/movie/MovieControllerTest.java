package dev.patika.movieapispringboot.movie;

import dev.patika.movieapispringboot.BaseIntegrationTest;
import dev.patika.movieapispringboot.movie.controller.MovieCreateResponse;
import dev.patika.movieapispringboot.movie.controller.MovieRequest;
import dev.patika.movieapispringboot.movie.controller.MovieResponse;
import dev.patika.movieapispringboot.movie.enums.Genre;
import dev.patika.movieapispringboot.movie.repository.MovieEntity;
import dev.patika.movieapispringboot.movie.repository.MovieJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MovieControllerTest extends BaseIntegrationTest {

    @Autowired
    MovieJpaRepository underTest;

    @Test
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void it_should_create_movie_without_actors() {
        // given
        String MOVIE_NAME = "Pulp Fiction";
        MovieRequest request = new MovieRequest();
        request.setName(MOVIE_NAME);
        request.setGenre(Genre.DRAMA);
        request.setReleaseYear(1994);
        request.setDirector("Quentin Tarantino");

        // when
        ResponseEntity<MovieCreateResponse> response = testRestTemplate.postForEntity("/api/v1/movie", request, MovieCreateResponse.class);

        // then
        Optional<MovieEntity> movie = underTest.findById(response.getBody().getId());
        assertThat(movie).isPresent();
        assertThat(movie.get().getName()).isEqualTo(MOVIE_NAME);
    }

    @Test
    @Sql(scripts = "/movie-create.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void it_should_retrieve_movie_without_actors() {
        // given
        // via Sql Annotation

        // when
        ResponseEntity<MovieResponse> response = testRestTemplate.getForEntity("/api/v1/movie?movieId=1001", MovieResponse.class);

        // then
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody())
                .extracting("name", "genre", "releaseYear", "director")
                .containsExactly("Pulp Fiction", Genre.DRAMA, 1994, "Quentin Tarantino");
    }
}
