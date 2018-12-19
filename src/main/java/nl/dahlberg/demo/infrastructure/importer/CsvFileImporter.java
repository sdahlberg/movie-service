package nl.dahlberg.demo.infrastructure.importer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import nl.dahlberg.demo.conversion.DomainConversionService;
import nl.dahlberg.demo.domain.model.MovieTitle;
import nl.dahlberg.demo.domain.repository.MovieTitleRepository;
import nl.dahlberg.demo.infrastructure.importer.jackson.converter.BooleanConverter;
import nl.dahlberg.demo.infrastructure.importer.model.TitleBasics;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class CsvFileImporter {
    private final DomainConversionService domainConversionService;
    private CsvMapper csvMapper;

    @PostConstruct
    public void initCsvMapper() {
        final SimpleModule module = new SimpleModule();
        module.addDeserializer(Boolean.class, new StdDelegatingDeserializer<>(new BooleanConverter()));

        csvMapper = new CsvMapper();
        csvMapper.registerModules(module, new JavaTimeModule());
    }

    public Stream<MovieTitle> importCsvStream(final InputStream inputStream) throws IOException {
        final CsvSchema schema =
                csvMapper.typedSchemaFor(TitleBasics.class)
                        .withHeader()
                        .withArrayElementSeparator(",")
                        .withoutQuoteChar()
                        .withNullValue("\\N")
                        .withColumnSeparator('\t');

        final MappingIterator<TitleBasics> titleBasicsIterator =
                csvMapper.readerFor(TitleBasics.class).with(schema).readValues(inputStream);

        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(titleBasicsIterator, Spliterator.ORDERED), false)
                .map(titleBasics -> domainConversionService.convert(titleBasics, MovieTitle.class));
    }
}
