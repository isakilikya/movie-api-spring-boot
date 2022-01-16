package dev.patika.movieapispringboot.movie.repository;

import dev.patika.movieapispringboot.movie.enums.Genre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "movie")
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private Integer releaseYear;

    @Column(nullable = false)
    private String director;
}
