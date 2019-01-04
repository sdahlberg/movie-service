package nl.dahlberg.movie.domain.model;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static nl.dahlberg.movie.SearchSpecifications.in;
import static nl.dahlberg.movie.SearchSpecifications.manyIn;

public class MovieTitleSearchSpecifications {
    public static Specification<MovieTitle> hasMovieTitleTypes(final List<MovieTitleType> movieTitleTypes) {
        return in(movieTitleTypes, "movieTitleType");
    }

    public static Specification<MovieTitle> hasMovieTitleGenres(final List<MovieTitleGenre> movieTitleGenres) {
        return manyIn(movieTitleGenres, "genres");
    }
}
