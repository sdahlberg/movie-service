package nl.dahlberg.demo.infrastructure.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;
import javax.annotation.PostConstruct;


public abstract class ConversionServiceAwareConverter<S, T> implements Converter<S, T> {

    @Autowired
    private ConversionService conversionService;

    protected ConversionService getConversionService() {
        return conversionService;
    }

    @PostConstruct
    public void register() {
        if (conversionService instanceof ConverterRegistry) {
            ((ConverterRegistry) conversionService).addConverter(this);
        }
    }
}
