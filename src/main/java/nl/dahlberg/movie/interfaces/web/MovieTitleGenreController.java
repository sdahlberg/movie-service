package nl.dahlberg.movie.interfaces.web;

import lombok.AllArgsConstructor;
import nl.dahlberg.movie.conversion.DomainConversionService;
import nl.dahlberg.movie.domain.model.MovieTitleGenre;
import nl.dahlberg.movie.domain.service.MovieTitleService;
import nl.dahlberg.movie.interfaces.model.MovieTitleGenreResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/movie-title-genre")
@AllArgsConstructor
public class MovieTitleGenreController {
    private final MovieTitleService movieTitleService;
    private final DomainConversionService domainConversionService;

    @GetMapping
    public List<MovieTitleGenreResource> getMovieTitleGenres() {
        final List<MovieTitleGenre> movieTitleGenres = movieTitleService.getMovieTitleGenres();
        return movieTitleGenres.stream()
                .map(movieTitleGenre -> domainConversionService.convert(movieTitleGenre, MovieTitleGenreResource.class))
                .collect(toList());
    }
}
