package nl.dahlberg.demo.importer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import nl.dahlberg.demo.importer.converter.BooleanConverter;
import nl.dahlberg.demo.importer.resource.TitleBasics;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvFileImporter {

    private CsvMapper csvMapper;

    @PostConstruct
    public void initCsvMapper() {
        final SimpleModule module = new SimpleModule();
        module.addDeserializer(Boolean.class, new StdDelegatingDeserializer<>(new BooleanConverter()));

        csvMapper = new CsvMapper();
        csvMapper.registerModules(module, new JavaTimeModule());
    }

    public void importCsvStream(final InputStream inputStream) throws IOException {
        final CsvSchema schema = csvMapper.typedSchemaFor(TitleBasics.class)
                .withHeader()
                .withArrayElementSeparator(",")
                .withoutQuoteChar()
                .withNullValue("\\N")
                .withColumnSeparator('\t');

        final MappingIterator<TitleBasics> objectMappingIterator = csvMapper.readerFor(TitleBasics.class).with(schema).readValues(inputStream);

        final List<TitleBasics> titles = new ArrayList<>();
        while (objectMappingIterator.hasNextValue()) {
            final TitleBasics titleBasics = objectMappingIterator.nextValue();
        }

        System.out.println("OK");
    }
}
