package nl.dahlberg.movie.infrastructure.messaging.listener;

import nl.dahlberg.movie.infrastructure.messaging.model.MovieTitleMessage;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
public class MovieListener {

    @StreamListener(Sink.INPUT)
    public void handleMovieTitleMessage(final MovieTitleMessage movieTitleMessage) {
        System.out.println("Received: " + movieTitleMessage);
    }
}
