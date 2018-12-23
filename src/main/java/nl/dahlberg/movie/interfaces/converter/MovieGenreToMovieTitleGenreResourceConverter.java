package nl.dahlberg.movie.interfaces.converter;

import nl.dahlberg.movie.domain.model.MovieGenre;
import nl.dahlberg.movie.interfaces.model.MovieTitleGenresResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieGenreToMovieTitleGenreResourceConverter implements Converter<MovieGenre, MovieTitleGenresResource> {
    @Override
    public MovieTitleGenresResource convert(final MovieGenre movieGenre) {
        return MovieTitleGenresResource.valueOf(movieGenre.name());
    }
}
