package nl.dahlberg.movie.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DomainConversionService {

    @Autowired
    @Qualifier("mvcConversionService")
    private ConversionService conversionService;

    public <T, U> List<T> convert(final List<U> list, final Class<T> type) {
        return list.stream().map(content -> conversionService.convert(content, type)).collect(toList());
    }

    public <T, U> Page<T> convert(final Page<U> page, final Class<T> type) {
        return page.map(content -> conversionService.convert(content, type));
    }

    public <T, U> T convert(final U content, final Class<T> type) {
        return conversionService.convert(content, type);
    }

    public void addConverter(final Converter converter) {
        if (conversionService instanceof ConverterRegistry) {
            ((ConverterRegistry) conversionService).addConverter(converter);
        }
    }
}
