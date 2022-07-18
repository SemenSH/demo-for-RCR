package ru.cbr.demorestservice.domain.model.converter;

import ru.cbr.demorestservice.domain.model.CreditOrganizationRegNum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RegNumConverter implements AttributeConverter<CreditOrganizationRegNum, String> {
    @Override
    public String convertToDatabaseColumn(CreditOrganizationRegNum attribute) {
        return attribute.getRegNum();
    }

    @Override
    public CreditOrganizationRegNum convertToEntityAttribute(String dbData) {
        return new CreditOrganizationRegNum(dbData);
    }
}
