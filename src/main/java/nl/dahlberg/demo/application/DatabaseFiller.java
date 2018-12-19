package nl.dahlberg.demo.application;

import lombok.AllArgsConstructor;
import nl.dahlberg.demo.domain.model.MovieTitle;
import nl.dahlberg.demo.domain.service.MovieTitleService;
import nl.dahlberg.demo.infrastructure.importer.CsvFileImporter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;

@Component
@AllArgsConstructor
public class DatabaseFiller {
    private final MovieTitleService movieTitleService;
    private final CsvFileImporter csvFileImporter;

    public void fillDatabase() {
        final ClassPathResource resource = new ClassPathResource("imports/title-basics.tsv");

        try {
            final long startRead = System.currentTimeMillis();
            final List<MovieTitle> movieTitles = csvFileImporter.importCsvStream(resource.getInputStream());
            final long startSave = System.currentTimeMillis();
            System.out.println("Reading movie titles in: " + (startSave - startRead) + "ms.");
            for (MovieTitle movieTitle : movieTitles) {
                movieTitleService.addMovieTitle(movieTitle);
            }
            System.out.println("Writing movie titles in: " + (System.currentTimeMillis() - startSave) + "ms.");
        } catch (IOException e) {
            throw new IllegalStateException("Should be able to read title-basics.tsv", e);
        }
    }
}
