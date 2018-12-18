package nl.dahlberg.demo.domain.service;

import lombok.AllArgsConstructor;
import nl.dahlberg.demo.domain.MovieTitle;
import nl.dahlberg.demo.infrastructure.repository.MovieTitleRepository;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class MovieTitleService {

    private MovieTitleRepository movieTitleRepository;

    public void addMovieTitle(final MovieTitle movieTitle) {
        final MovieTitle newMovieTitle = movieTitleRepository.save(movieTitle);

        System.out.println("New movieTitle with id: " + newMovieTitle.getId() + " - title: " + newMovieTitle.getPrimaryTitle());
    }
}
