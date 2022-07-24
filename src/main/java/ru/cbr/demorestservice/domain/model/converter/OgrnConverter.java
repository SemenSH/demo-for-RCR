package ru.cbr.demorestservice.domain.model.converter;

import ru.cbr.demorestservice.domain.type.Ogrn;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OgrnConverter implements AttributeConverter<Ogrn, String> {

    @Override
    public String convertToDatabaseColumn(Ogrn attribute) {
        return attribute.getOgrnType();
    }

    @Override
    public Ogrn convertToEntityAttribute(String dbData) {
        return new Ogrn(dbData);
    }
}
