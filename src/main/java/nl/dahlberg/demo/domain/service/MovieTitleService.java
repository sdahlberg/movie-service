package nl.dahlberg.demo.domain.service;

import lombok.AllArgsConstructor;
import nl.dahlberg.demo.domain.model.MovieTitle;
import nl.dahlberg.demo.domain.repository.MovieTitleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class MovieTitleService {
    private final MovieTitleRepository movieTitleRepository;

    public void addMovieTitle(final MovieTitle movieTitle) {
        movieTitleRepository.save(movieTitle);
    }

    public Page<MovieTitle> getMovieTitles(final Pageable pageable) {
        return movieTitleRepository.findAll(pageable);
    }
}
