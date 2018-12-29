package nl.dahlberg.movie.interfaces.converter;

import nl.dahlberg.movie.domain.model.MovieTitleType;
import nl.dahlberg.movie.interfaces.model.MovieTitleTypeResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieTitleTypeResourceToMovieTitleTypeConverter implements Converter<MovieTitleTypeResource, MovieTitleType> {
    @Override
    public MovieTitleType convert(final MovieTitleTypeResource source) {
        return MovieTitleType.valueOf(source.name());
    }
}
