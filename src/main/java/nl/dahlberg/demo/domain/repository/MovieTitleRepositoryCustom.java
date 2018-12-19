package nl.dahlberg.demo.domain.repository;

import nl.dahlberg.demo.domain.model.MovieTitle;

public interface MovieTitleRepositoryCustom {
    void saveAllBatched(Iterable<MovieTitle> movieTitles);
}
