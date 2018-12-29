package nl.dahlberg.movie.interfaces.web;

import lombok.AllArgsConstructor;
import nl.dahlberg.movie.application.DatabaseFiller;
import nl.dahlberg.movie.conversion.DomainConversionService;
import nl.dahlberg.movie.domain.model.MovieTitle;
import nl.dahlberg.movie.domain.model.MovieTitleFilterCriteria;
import nl.dahlberg.movie.domain.model.MovieTitleType;
import nl.dahlberg.movie.domain.service.MovieTitleService;
import nl.dahlberg.movie.interfaces.model.MovieTitleFilterCriteriaResource;
import nl.dahlberg.movie.interfaces.model.MovieTitleTypeResource;
import nl.dahlberg.movie.interfaces.model.MovieTitlesResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
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

    @GetMapping("/movieTitles/search")
    public Page<MovieTitlesResource> search(final MovieTitleFilterCriteriaResource filterCriteriaResource, final Pageable pageable) {
        final MovieTitleFilterCriteria filterCriteria = domainConversionService.convert(filterCriteriaResource, MovieTitleFilterCriteria.class);
        final Page<MovieTitle> search = movieTitleService.search(filterCriteria, pageable);
        return domainConversionService.convert(search, MovieTitlesResource.class);
    }

    @GetMapping("/movieTitleTypes")
    public List<MovieTitleTypeResource> getMovieTitlesTypes() {
        final List<MovieTitleType> movieTitleTypes = movieTitleService.getMovieTitleTypes();
        return movieTitleTypes.stream()
                .map(movieTitleType -> domainConversionService.convert(movieTitleType, MovieTitleTypeResource.class))
                .collect(toList());
    }
}
