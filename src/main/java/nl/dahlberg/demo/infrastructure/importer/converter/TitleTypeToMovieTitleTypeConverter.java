package nl.dahlberg.demo.infrastructure.importer.converter;

import nl.dahlberg.demo.domain.MovieTitleType;
import nl.dahlberg.demo.infrastructure.common.ConversionServiceAwareConverter;
import nl.dahlberg.demo.infrastructure.importer.domain.TitleType;
import org.springframework.stereotype.Component;

@Component
public class TitleTypeToMovieTitleTypeConverter extends ConversionServiceAwareConverter<TitleType, MovieTitleType> {
    @Override
    public MovieTitleType convert(final TitleType titleType) {
        return MovieTitleType.valueOf(titleType.name());
    }
}
