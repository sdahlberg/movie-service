package nl.dahlberg.movie.domain.repository;

import nl.dahlberg.movie.domain.model.MovieTitle;
import nl.dahlberg.movie.domain.model.MovieTitleType;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MovieTitleRepository extends PagingAndSortingRepository<MovieTitle, Long>, MovieTitleRepositoryCustom,
        JpaSpecificationExecutor<MovieTitle> {

    @Query("select distinct mt.movieTitleType from MovieTitle mt")
    List<MovieTitleType> findMovieTitleTypes();
}
