package nl.dahlberg.demo.interfaces.converter;

import nl.dahlberg.demo.domain.model.MovieTitleType;
import nl.dahlberg.demo.interfaces.model.MovieTitleTypeResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieTitleTypeToMovieTitleTypeResourceConverter
        implements Converter<MovieTitleType, MovieTitleTypeResource> {

    @Override
    public MovieTitleTypeResource convert(MovieTitleType movieTitleType) {
        return MovieTitleTypeResource.valueOf(movieTitleType.name());
    }
}
