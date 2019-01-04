package nl.dahlberg.movie.interfaces.converter;

import nl.dahlberg.movie.interfaces.model.MovieTitleGenreResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * String to MovieTitleGenreResource converter. Primary use is by Spring itself: the MovieTitleGenreResource request parameter
 * (through MovieTitleFilterCriteria) is constructed by using this converter.
 */
@Component
public class StringToMovieTitleGenreResourceConverter implements Converter<String, MovieTitleGenreResource> {
    @Override
    public MovieTitleGenreResource convert(final String source) {
        return MovieTitleGenreResource.findByValue(source);
    }
}
