package nl.dahlberg.demo.infrastructure.importer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.RequiredArgsConstructor;
import nl.dahlberg.demo.configuration.CsvMapperProvider;
import nl.dahlberg.demo.conversion.DomainConversionService;
import nl.dahlberg.demo.domain.model.MovieTitle;
import nl.dahlberg.demo.infrastructure.importer.model.TitleBasics;
import org.springframework.stereotype.Component;

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
    private final CsvMapperProvider csvMapperProvider;

    public Stream<MovieTitle> importCsvStream(final InputStream inputStream) throws IOException {
        final CsvMapper csvMapper = csvMapperProvider.getCsvMapper();
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
