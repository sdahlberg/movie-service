package nl.dahlberg.movie.infrastructure.importer.converter;

import nl.dahlberg.movie.domain.model.MovieGenre;
import nl.dahlberg.movie.domain.model.MovieTitle;
import nl.dahlberg.movie.domain.model.MovieTitleType;
import nl.dahlberg.movie.infrastructure.common.ConversionServiceAwareConverter;
import nl.dahlberg.movie.infrastructure.importer.model.TitleBasics;
import org.springframework.stereotype.Component;

@Component
public class TitleBasicsToMovieTitleConverter extends ConversionServiceAwareConverter<TitleBasics, MovieTitle> {

    @Override
    public MovieTitle convert(final TitleBasics titleBasics) {
        return MovieTitle.create()
                .tconst(titleBasics.getTconst())
                .movieTitleType(
                        getDomainConversionService().convert(titleBasics.getTitleType(), MovieTitleType.class))
                .primaryTitle(titleBasics.getPrimaryTitle())
                .originalTitle(titleBasics.getOriginalTitle())
                .startYear(titleBasics.getStartYear())
                .endYear(titleBasics.getEndYear())
                .isAdult(titleBasics.getIsAdult())
                .runtimeMinutes(titleBasics.getRuntimeMinutes())
                .genres(getDomainConversionService().convert(titleBasics.getGenres(), MovieGenre.class))
                .build();
    }
}
