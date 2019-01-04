package nl.dahlberg.movie.application;

import lombok.AllArgsConstructor;
import nl.dahlberg.movie.domain.model.MovieTitle;
import nl.dahlberg.movie.domain.service.MovieTitleService;
import nl.dahlberg.movie.infrastructure.importer.CsvFileImporter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class DatabaseFiller {
    private final MovieTitleService movieTitleService;
    private final CsvFileImporter csvFileImporter;

    public void fillDatabase() {
        //final ClassPathResource resource = new ClassPathResource("imports/title-basics.tsv");
        final ClassPathResource resource = new ClassPathResource("imports/test.tsv");

        final long start = System.currentTimeMillis();
        try {
            final Stream<MovieTitle> movieTitleStream = csvFileImporter.importCsvStream(resource.getInputStream());
            movieTitleService.addMovieTitles(movieTitleStream);
        } catch (IOException e) {
            throw new IllegalStateException("Should be able to read title-basics.tsv", e);
        }

        System.out.println("Import finished in " + (System.currentTimeMillis() - start) + "ms.");
    }
}
