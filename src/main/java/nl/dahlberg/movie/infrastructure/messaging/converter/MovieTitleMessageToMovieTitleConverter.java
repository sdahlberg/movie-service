package nl.dahlberg.movie.infrastructure.messaging.converter;

import nl.dahlberg.movie.domain.model.MovieTitle;
import nl.dahlberg.movie.domain.model.MovieTitleGenre;
import nl.dahlberg.movie.domain.model.MovieTitleType;
import nl.dahlberg.movie.infrastructure.common.ConversionServiceAwareConverter;
import nl.dahlberg.movie.infrastructure.messaging.model.MovieTitleMessage;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
public class MovieTitleMessageToMovieTitleConverter extends ConversionServiceAwareConverter<MovieTitleMessage, MovieTitle> {
    @Override
    public MovieTitle convert(final MovieTitleMessage movieTitleMessage) {
        return MovieTitle.builder()
                .uuid(movieTitleMessage.getUuid())
                .tconst(movieTitleMessage.getTconst())
                .movieTitleType(getDomainConversionService().convert(movieTitleMessage.getMovieTitleType(), MovieTitleType.class))
                .primaryTitle(movieTitleMessage.getPrimaryTitle())
                .originalTitle(movieTitleMessage.getOriginalTitle())
                .isAdult(movieTitleMessage.isAdult())
                .startYear(movieTitleMessage.getStartYear())
                .endYear(movieTitleMessage.getEndYear())
                .runtimeMinutes(movieTitleMessage.getRuntimeMinutes())
                .genres(movieTitleMessage.getGenres().stream()
                        .map(movieTitleGenreMessage ->
                                getDomainConversionService().convert(movieTitleGenreMessage, MovieTitleGenre.class))
                        .collect(toList()))
                .build();
    }
}
