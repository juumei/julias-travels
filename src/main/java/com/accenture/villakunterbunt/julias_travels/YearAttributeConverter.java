package com.accenture.villakunterbunt.julias_travels;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Year;

@Converter(autoApply = true)
public class YearAttributeConverter implements AttributeConverter<Year, Integer> {

    @Override
    public Integer convertToDatabaseColumn(
            Year attribute) {
        if (attribute != null) {
            return (Integer) attribute.getValue();
        }
        return null;
    }

    @Override
    public Year convertToEntityAttribute(
            Integer dbData) {
        if (dbData != null) {
            return Year.of(dbData);
        }
        return null;
    }
}
