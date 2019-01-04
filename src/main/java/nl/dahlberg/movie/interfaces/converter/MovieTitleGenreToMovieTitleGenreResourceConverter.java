package nl.dahlberg.movie.interfaces.converter;

import nl.dahlberg.movie.domain.model.MovieTitleGenre;
import nl.dahlberg.movie.interfaces.model.MovieTitleGenreResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieTitleGenreToMovieTitleGenreResourceConverter implements Converter<MovieTitleGenre, MovieTitleGenreResource> {
    @Override
    public MovieTitleGenreResource convert(final MovieTitleGenre movieTitleGenre) {
        return MovieTitleGenreResource.valueOf(movieTitleGenre.name());
    }
}
