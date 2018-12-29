package nl.dahlberg.movie.domain.model;

import nl.dahlberg.movie.SearchSpecifications;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class MovieTitleSearchSpecifications {
    public static Specification<MovieTitle> hasMovieTitleTypes(final List<MovieTitleType> movieTitleTypes) {
        return SearchSpecifications.in(movieTitleTypes, "movieTitleType");
    }
}
