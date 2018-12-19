package nl.dahlberg.demo.interfaces.converter;

import nl.dahlberg.demo.domain.model.MovieTitle;
import nl.dahlberg.demo.infrastructure.common.ConversionServiceAwareConverter;
import nl.dahlberg.demo.interfaces.model.MovieTitleTypeResource;
import nl.dahlberg.demo.interfaces.model.MovieTitlesResource;
import org.springframework.stereotype.Component;

@Component
public class MovieTitleToMovieTitlesResourceConverter
        extends ConversionServiceAwareConverter<MovieTitle, MovieTitlesResource> {

    @Override
    public MovieTitlesResource convert(final MovieTitle movieTitle) {
        return MovieTitlesResource.builder() //
                .uuid(movieTitle.getUuid()) //
                .tconst(movieTitle.getTconst()) //
                .movieTitleType(getDomainConversionService().convert(movieTitle.getMovieTitleType(), MovieTitleTypeResource.class))
                .primaryTitle(movieTitle.getPrimaryTitle()) //
                .build();
    }
}
