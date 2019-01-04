package nl.dahlberg.movie.infrastructure.repository.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Year;

@Converter(autoApply = true)
public class YearAttributeConverter implements AttributeConverter<Year, Short> {

    @Override
    public Short convertToDatabaseColumn(final Year year) {
        if (year == null) {
            return null;
        }
        return (short) year.getValue();
    }

    @Override
    public Year convertToEntityAttribute(final Short year) {
        if (year == null) {
            return null;
        }
        return Year.of(year);
    }
}

