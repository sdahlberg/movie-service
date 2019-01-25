package nl.dahlberg.movie.domain.service;

import lombok.AllArgsConstructor;
import nl.dahlberg.movie.domain.model.MovieTitle;
import nl.dahlberg.movie.domain.model.MovieTitleFilterCriteria;
import nl.dahlberg.movie.domain.model.MovieTitleGenre;
import nl.dahlberg.movie.domain.model.MovieTitleType;
import nl.dahlberg.movie.domain.repository.MovieTitleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static nl.dahlberg.movie.domain.model.MovieTitleSearchSpecifications.hasMovieTitleGenres;
import static nl.dahlberg.movie.domain.model.MovieTitleSearchSpecifications.hasMovieTitleTypes;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
@AllArgsConstructor
public class MovieTitleService {
    private final MovieTitleRepository movieTitleRepository;

    public void addMovieTitles(final Stream<MovieTitle> movieTitleStream) {
        int[] counter = {0};
        long[] now = {System.currentTimeMillis()};
        movieTitleRepository.saveAllBatched(movieTitleStream
                .peek(movieTitle -> {
                    if (counter[0] % 1000 == 0 && counter[0] > 0) {
                        System.out.println("Save " + counter[0] + " in " + (System.currentTimeMillis() - now[0]) + "ms");
                        now[0] = System.currentTimeMillis();
                    }
                    counter[0]++;
                })
                ::iterator);
    }

    public Page<MovieTitle> getMovieTitles(final Pageable pageable) {
        return movieTitleRepository.findAll(pageable);
    }

    public Page<MovieTitle> search(final MovieTitleFilterCriteria filterCriteria, final Pageable pageable) {
        return movieTitleRepository.findAll(
                where(hasMovieTitleTypes(filterCriteria.getMovieTitleTypes()))
                        .and(hasMovieTitleGenres(filterCriteria.getMovieTitleGenres())), pageable
        );
    }

    public List<MovieTitleType> getMovieTitleTypes() {
        return Arrays.asList(MovieTitleType.values());
    }

    public List<MovieTitleGenre> getMovieTitleGenres() {
        return Arrays.asList(MovieTitleGenre.values());
    }
}
