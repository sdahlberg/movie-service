package nl.dahlberg.demo.infrastructure.importer.converter;

import nl.dahlberg.demo.domain.model.MovieTitle;
import nl.dahlberg.demo.domain.model.MovieTitleType;
import nl.dahlberg.demo.infrastructure.common.ConversionServiceAwareConverter;
import nl.dahlberg.demo.infrastructure.importer.model.TitleBasics;
import org.springframework.stereotype.Component;

@Component
public class TitleBasicsToMovieTitleConverter extends ConversionServiceAwareConverter<TitleBasics, MovieTitle> {

    @Override
    public MovieTitle convert(final TitleBasics titleBasics) {
        return MovieTitle.create() //
                         .tconst(titleBasics.getTconst()) //
                         .movieTitleType(
                           getConversionService().convert(titleBasics.getTitleType(), MovieTitleType.class))
                         .primaryTitle(titleBasics.getPrimaryTitle()) //
                         .build();
    }
}
