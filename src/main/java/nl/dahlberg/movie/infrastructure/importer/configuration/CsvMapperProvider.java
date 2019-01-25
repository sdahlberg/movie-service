package nl.dahlberg.movie.infrastructure.importer.configuration;

import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import nl.dahlberg.movie.infrastructure.importer.jackson.converter.BooleanConverter;
import org.springframework.stereotype.Component;

@Component
public class CsvMapperProvider {
    public CsvMapper getCsvMapper() {
        final SimpleModule module = new SimpleModule();
        module.addDeserializer(Boolean.class, new StdDelegatingDeserializer<>(new BooleanConverter()));

        final CsvMapper csvMapper = new CsvMapper();
        csvMapper.registerModules(module, new JavaTimeModule());
        return csvMapper;
    }
}
