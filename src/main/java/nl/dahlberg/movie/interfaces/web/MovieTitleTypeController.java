package nl.dahlberg.movie.interfaces.web;

import lombok.AllArgsConstructor;
import nl.dahlberg.movie.conversion.DomainConversionService;
import nl.dahlberg.movie.domain.model.MovieTitleType;
import nl.dahlberg.movie.domain.service.MovieTitleService;
import nl.dahlberg.movie.interfaces.model.MovieTitleTypeResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/movie-title-type")
@AllArgsConstructor
public class MovieTitleTypeController {
    private final MovieTitleService movieTitleService;
    private final DomainConversionService domainConversionService;

    @GetMapping
    public List<MovieTitleTypeResource> getMovieTitlesTypes() {
        final List<MovieTitleType> movieTitleTypes = movieTitleService.getMovieTitleTypes();
        return movieTitleTypes.stream()
                .map(movieTitleType -> domainConversionService.convert(movieTitleType, MovieTitleTypeResource.class))
                .collect(toList());
    }
}
