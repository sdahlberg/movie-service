package nl.dahlberg.movie.interfaces.web;

import lombok.AllArgsConstructor;
import nl.dahlberg.movie.application.DatabaseFiller;
import nl.dahlberg.movie.conversion.DomainConversionService;
import nl.dahlberg.movie.domain.model.MovieTitle;
import nl.dahlberg.movie.domain.service.MovieTitleService;
import nl.dahlberg.movie.interfaces.model.MovieTitlesResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MovieTitleController {
    private final DatabaseFiller databaseFiller;
    private final MovieTitleService movieTitleService;
    private final DomainConversionService domainConversionService;

    @GetMapping("/test")
    public String test() {
        databaseFiller.fillDatabase();
        return "Hello world";
    }

    @GetMapping("/movies")
    public Page<MovieTitlesResource> getMovieTitles(final Pageable pageable) {
        final Page<MovieTitle> movieTitles = movieTitleService.getMovieTitles(pageable);
        return domainConversionService.convert(movieTitles, MovieTitlesResource.class);
    }
}
