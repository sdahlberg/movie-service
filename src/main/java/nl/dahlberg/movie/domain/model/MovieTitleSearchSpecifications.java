package nl.dahlberg.movie.domain.model;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class MovieTitleSearchSpecifications {

    public static Specification<MovieTitle> hasMovieTitleTypes(final List<MovieTitleType> movieTitleTypes) {
        return (Specification<MovieTitle>) (root, query, criteriaBuilder) -> !movieTitleTypes.isEmpty() ? root.get("movieTitleType").in(movieTitleTypes) : null;
    }
}
