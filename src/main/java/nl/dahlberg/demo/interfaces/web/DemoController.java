package nl.dahlberg.demo.interfaces.web;

import lombok.AllArgsConstructor;
import nl.dahlberg.demo.application.DatabaseFiller;
import nl.dahlberg.demo.conversion.DomainConversionService;
import nl.dahlberg.demo.domain.model.MovieTitle;
import nl.dahlberg.demo.domain.service.MovieTitleService;
import nl.dahlberg.demo.interfaces.model.MovieTitlesResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class DemoController {
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
