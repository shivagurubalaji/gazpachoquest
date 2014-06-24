package net.sf.gazpachoquest.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import net.sf.gazpachoquest.types.RandomizationStrategy;

@Converter(autoApply = true)
public class RandomizationStrategyConverter implements AttributeConverter<RandomizationStrategy, String> {

    @Override
    public String convertToDatabaseColumn(RandomizationStrategy type) {
        return type == null ? RandomizationStrategy.NONE.getCode() : type.getCode();
    }

    @Override
    public RandomizationStrategy convertToEntityAttribute(String code) {
        return RandomizationStrategy.fromCode(code);
    }

}
