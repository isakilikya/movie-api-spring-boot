package dev.patika.movieapispringboot.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Movie {
    private Long id;
    private String name;
    private Genre genre;
    private Integer releaseYear;
    private String director;
    private List<Actor> cast;
}
