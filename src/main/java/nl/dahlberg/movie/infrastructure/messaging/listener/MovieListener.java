package nl.dahlberg.movie.infrastructure.messaging.listener;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import nl.dahlberg.movie.conversion.DomainConversionService;
import nl.dahlberg.movie.domain.model.MovieTitle;
import nl.dahlberg.movie.domain.service.MovieTitleService;
import nl.dahlberg.movie.infrastructure.messaging.model.MovieTitleMessage;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import static java.text.MessageFormat.format;

@Log
@AllArgsConstructor
@Component
public class MovieListener {
    private final MovieTitleService movieTitleService;
    private final DomainConversionService domainConversionService;

    @StreamListener(Sink.INPUT)
    public void handleMovieTitleMessage(final MovieTitleMessage movieTitleMessage) {
        final MovieTitle movieTitle = domainConversionService.convert(movieTitleMessage, MovieTitle.class);
        final MovieTitle newMovieTitle = movieTitleService.addMovieTitle(movieTitle);
        log.info(format("New movieTitle: {0}", newMovieTitle));
    }
}
