package nl.dahlberg.movie.domain.repository;

import nl.dahlberg.movie.domain.model.MovieTitle;

public interface MovieTitleRepositoryCustom {
    void saveAllBatched(Iterable<MovieTitle> movieTitles);
}
