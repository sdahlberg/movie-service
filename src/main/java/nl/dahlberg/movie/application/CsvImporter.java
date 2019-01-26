package nl.dahlberg.movie.application;

import nl.dahlberg.movie.domain.model.MovieTitle;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

public interface CsvImporter {
    Stream<MovieTitle> importMovieTitleInputStream(final InputStream inputStream) throws IOException;
}
