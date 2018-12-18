package nl.dahlberg.demo.infrastructure.importer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import nl.dahlberg.demo.domain.MovieTitle;
import nl.dahlberg.demo.infrastructure.importer.domain.TitleBasics;
import nl.dahlberg.demo.infrastructure.importer.jackson.converter.BooleanConverter;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class CsvFileImporter {

    private final ConversionService conversionService;

    private CsvMapper csvMapper;

    @PostConstruct
    public void initCsvMapper() {
        final SimpleModule module = new SimpleModule();
        module.addDeserializer(Boolean.class, new StdDelegatingDeserializer<>(new BooleanConverter()));

        csvMapper = new CsvMapper();
        csvMapper.registerModules(module, new JavaTimeModule());
    }

    public List<MovieTitle> importCsvStream(final InputStream inputStream) throws IOException {
        final CsvSchema schema =
          csvMapper.typedSchemaFor(TitleBasics.class).withHeader().withArrayElementSeparator(",").withoutQuoteChar()
                   .withNullValue("\\N").withColumnSeparator('\t');

        final MappingIterator<TitleBasics> objectMappingIterator =
          csvMapper.readerFor(TitleBasics.class).with(schema).readValues(inputStream);

        final List<TitleBasics> titles = new ArrayList<>();
        while (objectMappingIterator.hasNextValue()) {
            titles.add(objectMappingIterator.nextValue());
        }

        return titles.stream().map(titleBasics -> conversionService.convert(titleBasics, MovieTitle.class))
                     .collect(toList());
    }
}
