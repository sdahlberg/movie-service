package nl.dahlberg.demo.infrastructure.repository;

import nl.dahlberg.demo.domain.MovieTitle;
import org.springframework.data.repository.CrudRepository;

public interface MovieTitleRepository extends CrudRepository<MovieTitle, Long> {}
