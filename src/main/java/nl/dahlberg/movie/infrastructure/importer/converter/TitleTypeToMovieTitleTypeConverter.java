package nl.dahlberg.movie.infrastructure.importer.converter;

import nl.dahlberg.movie.domain.model.MovieTitleType;
import nl.dahlberg.movie.infrastructure.common.ConversionServiceAwareConverter;
import nl.dahlberg.movie.infrastructure.importer.model.TitleType;
import org.springframework.stereotype.Component;

@Component
public class TitleTypeToMovieTitleTypeConverter extends ConversionServiceAwareConverter<TitleType, MovieTitleType> {
    @Override
    public MovieTitleType convert(final TitleType titleType) {
        return MovieTitleType.valueOf(titleType.name());
    }
}
