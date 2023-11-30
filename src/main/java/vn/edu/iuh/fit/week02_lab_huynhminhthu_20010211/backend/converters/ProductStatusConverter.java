package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.ProductStatus;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ProductStatusConverter implements AttributeConverter<ProductStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProductStatus attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValues();
    }

    @Override
    public ProductStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }

        return Stream.of(ProductStatus.values())
                .filter(c -> c.getValues() == dbData)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}