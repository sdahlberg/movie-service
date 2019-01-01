package nl.dahlberg.movie.interfaces.converter;

import nl.dahlberg.movie.domain.model.MovieTitleGenre;
import nl.dahlberg.movie.interfaces.model.MovieTitleGenreResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieTitleGenreResourceToMovieTitleGenreConverter implements Converter<MovieTitleGenreResource, MovieTitleGenre> {
    @Override
    public MovieTitleGenre convert(final MovieTitleGenreResource source) {
        return MovieTitleGenre.valueOf(source.name());
    }
}
