package nl.dahlberg.movie.interfaces.converter;

import nl.dahlberg.movie.domain.model.MovieTitleFilterCriteria;
import nl.dahlberg.movie.domain.model.MovieTitleGenre;
import nl.dahlberg.movie.domain.model.MovieTitleType;
import nl.dahlberg.movie.infrastructure.common.ConversionServiceAwareConverter;
import nl.dahlberg.movie.interfaces.model.MovieTitleFilterCriteriaResource;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
public class MovieTitleFilterCriteriaResourceToMovieTitleFilterCriteriaConverter extends ConversionServiceAwareConverter<MovieTitleFilterCriteriaResource, MovieTitleFilterCriteria> {
    @Override
    public MovieTitleFilterCriteria convert(final MovieTitleFilterCriteriaResource filterCriteriaResource) {
        return MovieTitleFilterCriteria.builder()
                .movieTitleTypes(filterCriteriaResource.getMovieTitleTypes().stream()
                        .map(source -> getDomainConversionService().convert(source, MovieTitleType.class))
                        .collect(toList()))
                .movieTitleGenres(filterCriteriaResource.getMovieTitleGenres().stream()
                        .map(source -> getDomainConversionService().convert(source, MovieTitleGenre.class))
                        .collect(toList()))
                .build();
    }
}
