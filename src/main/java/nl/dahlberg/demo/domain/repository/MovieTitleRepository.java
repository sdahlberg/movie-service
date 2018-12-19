package nl.dahlberg.demo.domain.repository;

import nl.dahlberg.demo.domain.model.MovieTitle;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovieTitleRepository extends PagingAndSortingRepository<MovieTitle, Long> {}
