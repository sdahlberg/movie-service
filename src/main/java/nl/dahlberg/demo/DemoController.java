package nl.dahlberg.demo;

import lombok.AllArgsConstructor;
import nl.dahlberg.demo.importer.CsvFileImporter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;

@RestController
@AllArgsConstructor
public class DemoController {

    private final CsvFileImporter csvFileImporter;

    @PostConstruct
    @GetMapping("/test")
    public String test() throws IOException {
        final ClassPathResource resource = new ClassPathResource("imports/title-basics.tsv");
        csvFileImporter.importCsvStream(resource.getInputStream());
        return "Hello world";
    }
}
