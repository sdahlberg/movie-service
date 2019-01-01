package nl.dahlberg.movie.interfaces.converter;

import nl.dahlberg.movie.domain.model.MovieTitle;
import nl.dahlberg.movie.infrastructure.common.ConversionServiceAwareConverter;
import nl.dahlberg.movie.interfaces.model.MovieTitleGenreResource;
import nl.dahlberg.movie.interfaces.model.MovieTitleResource;
import nl.dahlberg.movie.interfaces.model.MovieTitleTypeResource;
import org.springframework.stereotype.Component;

import static java.util.stream.Collectors.toList;

@Component
public class MovieTitleToMovieTitleResourceConverter extends ConversionServiceAwareConverter<MovieTitle, MovieTitleResource> {
    @Override
    public MovieTitleResource convert(final MovieTitle movieTitle) {
        return MovieTitleResource.builder()
                .uuid(movieTitle.getUuid())
                .tconst(movieTitle.getTconst())
                .movieTitleType(getDomainConversionService().convert(movieTitle.getMovieTitleType(), MovieTitleTypeResource.class))
                .primaryTitle(movieTitle.getPrimaryTitle())
                .originalTitle(movieTitle.getOriginalTitle())
                .isAdult(movieTitle.isAdult())
                .startYear(movieTitle.getStartYear())
                .endYear(movieTitle.getEndYear())
                .runtimeMinutes(movieTitle.getRuntimeMinutes())
                .genres(movieTitle.getGenres().stream()
                        .map(movieGenre -> getDomainConversionService().convert(movieGenre, MovieTitleGenreResource.class))
                        .collect(toList()))
                .build();
    }
}
