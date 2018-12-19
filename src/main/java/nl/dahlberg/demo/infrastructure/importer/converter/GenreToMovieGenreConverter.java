package nl.dahlberg.demo.infrastructure.importer.converter;

import nl.dahlberg.demo.domain.model.MovieGenre;
import nl.dahlberg.demo.infrastructure.importer.model.Genre;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GenreToMovieGenreConverter implements Converter<Genre, MovieGenre> {
    @Override
    public MovieGenre convert(final Genre genre) {
        return MovieGenre.valueOf(genre.name());
    }
}
