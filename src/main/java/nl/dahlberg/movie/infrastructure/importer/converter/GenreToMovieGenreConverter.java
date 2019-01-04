package nl.dahlberg.movie.infrastructure.importer.converter;

import nl.dahlberg.movie.domain.model.MovieTitleGenre;
import nl.dahlberg.movie.infrastructure.importer.model.Genre;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GenreToMovieGenreConverter implements Converter<Genre, MovieTitleGenre> {
    @Override
    public MovieTitleGenre convert(final Genre genre) {
        return MovieTitleGenre.valueOf(genre.name());
    }
}
