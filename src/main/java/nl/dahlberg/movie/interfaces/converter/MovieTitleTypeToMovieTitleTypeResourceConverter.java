package nl.dahlberg.movie.interfaces.converter;

import nl.dahlberg.movie.domain.model.MovieTitleType;
import nl.dahlberg.movie.interfaces.model.MovieTitleTypeResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieTitleTypeToMovieTitleTypeResourceConverter implements Converter<MovieTitleType, MovieTitleTypeResource> {
    @Override
    public MovieTitleTypeResource convert(MovieTitleType movieTitleType) {
        return MovieTitleTypeResource.valueOf(movieTitleType.name());
    }
}
