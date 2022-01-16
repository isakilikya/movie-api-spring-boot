package dev.patika.movieapispringboot.movie.controller;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieCreateResponse {

    private Long id;

    public static MovieCreateResponse convertToMovieCreateREsponse(Long id) {
        return MovieCreateResponse.builder()
                .id(id)
                .build();
    }
}
