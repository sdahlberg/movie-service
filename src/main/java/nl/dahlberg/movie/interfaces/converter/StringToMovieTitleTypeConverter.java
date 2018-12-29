package nl.dahlberg.movie.interfaces.converter;

import nl.dahlberg.movie.interfaces.model.MovieTitleTypeResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToMovieTitleTypeConverter implements Converter<String, MovieTitleTypeResource> {
    @Override
    public MovieTitleTypeResource convert(final String source) {
        return MovieTitleTypeResource.findByValue(source);
    }
}
