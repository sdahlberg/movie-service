package nl.dahlberg.movie.interfaces.converter;

import nl.dahlberg.movie.interfaces.model.MovieTitleTypeResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * String to MovieTitleType converter. Primary use is by Spring itself: the MovieTitleTypeResource request parameter
 * (through MovieTitleFilterCriteria) is constructed by using this converter.
 */
@Component
public class StringToMovieTitleTypeConverter implements Converter<String, MovieTitleTypeResource> {
    @Override
    public MovieTitleTypeResource convert(final String source) {
        return MovieTitleTypeResource.findByValue(source);
    }
}
