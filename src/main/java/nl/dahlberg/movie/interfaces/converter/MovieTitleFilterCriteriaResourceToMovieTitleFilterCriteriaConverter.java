package nl.dahlberg.movie.interfaces.converter;

import nl.dahlberg.movie.domain.model.MovieTitleFilterCriteria;
import nl.dahlberg.movie.domain.model.MovieTitleType;
import nl.dahlberg.movie.infrastructure.common.ConversionServiceAwareConverter;
import nl.dahlberg.movie.interfaces.model.MovieTitleFilterCriteriaResource;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
public class MovieTitleFilterCriteriaResourceToMovieTitleFilterCriteriaConverter extends ConversionServiceAwareConverter<MovieTitleFilterCriteriaResource, MovieTitleFilterCriteria> {
    @Override
    public MovieTitleFilterCriteria convert(final MovieTitleFilterCriteriaResource source) {
        return MovieTitleFilterCriteria.builder()
                .movieTitleTypes(source.getMovieTitleTypes().stream()
                        .map(movieTitleTypeResource -> getDomainConversionService().convert(movieTitleTypeResource, MovieTitleType.class))
                        .collect(toList()))
                .build();
    }
}
