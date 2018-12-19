package nl.dahlberg.demo.infrastructure.common;

import nl.dahlberg.demo.conversion.DomainConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import javax.annotation.PostConstruct;

public abstract class ConversionServiceAwareConverter<S, T> implements Converter<S, T> {

    @Autowired
    private DomainConversionService domainConversionService;

    protected DomainConversionService getDomainConversionService() {
        return domainConversionService;
    }

    @PostConstruct
    public void register() {
        domainConversionService.addConverter(this);
    }
}
