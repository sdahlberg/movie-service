package nl.dahlberg.movie.interfaces.web;

import lombok.AllArgsConstructor;
import nl.dahlberg.movie.application.DatabaseFiller;
import nl.dahlberg.movie.conversion.DomainConversionService;
import nl.dahlberg.movie.domain.model.MovieTitle;
import nl.dahlberg.movie.domain.model.MovieTitleFilterCriteria;
import nl.dahlberg.movie.domain.model.MovieTitleGenre;
import nl.dahlberg.movie.domain.model.MovieTitleType;
import nl.dahlberg.movie.domain.service.MovieTitleService;
import nl.dahlberg.movie.interfaces.model.MovieTitleFilterCriteriaResource;
import nl.dahlberg.movie.interfaces.model.MovieTitleGenreResource;
import nl.dahlberg.movie.interfaces.model.MovieTitleResource;
import nl.dahlberg.movie.interfaces.model.MovieTitleTypeResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/movie-title")
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

    @GetMapping
    public Page<MovieTitleResource> getMovieTitles(final Pageable pageable) {
        final Page<MovieTitle> movieTitles = movieTitleService.getMovieTitles(pageable);
        return domainConversionService.convert(movieTitles, MovieTitleResource.class);
    }

    @GetMapping("/search")
    public Page<MovieTitleResource> search(final MovieTitleFilterCriteriaResource filterCriteriaResource, final Pageable pageable) {
        final MovieTitleFilterCriteria filterCriteria = domainConversionService.convert(filterCriteriaResource, MovieTitleFilterCriteria.class);
        final Page<MovieTitle> search = movieTitleService.search(filterCriteria, pageable);
        return domainConversionService.convert(search, MovieTitleResource.class);
    }
}
