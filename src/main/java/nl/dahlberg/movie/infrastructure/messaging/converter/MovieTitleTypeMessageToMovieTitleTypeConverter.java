package nl.dahlberg.movie.infrastructure.messaging.converter;

import nl.dahlberg.movie.domain.model.MovieTitleType;
import nl.dahlberg.movie.infrastructure.messaging.model.MovieTitleTypeMessage;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieTitleTypeMessageToMovieTitleTypeConverter implements Converter<MovieTitleTypeMessage, MovieTitleType> {
    @Override
    public MovieTitleType convert(final MovieTitleTypeMessage movieTitleTypeMessage) {
        return MovieTitleType.valueOf(movieTitleTypeMessage.name());
    }
}
