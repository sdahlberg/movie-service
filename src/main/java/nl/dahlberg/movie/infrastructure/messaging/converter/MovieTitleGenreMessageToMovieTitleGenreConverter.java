package nl.dahlberg.movie.infrastructure.messaging.converter;

import nl.dahlberg.movie.domain.model.MovieTitleGenre;
import nl.dahlberg.movie.infrastructure.messaging.model.MovieTitleGenreMessage;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieTitleGenreMessageToMovieTitleGenreConverter implements Converter<MovieTitleGenreMessage, MovieTitleGenre> {
    @Override
    public MovieTitleGenre convert(final MovieTitleGenreMessage movieTitleGenreMessage) {
        return MovieTitleGenre.valueOf(movieTitleGenreMessage.name());
    }
}
