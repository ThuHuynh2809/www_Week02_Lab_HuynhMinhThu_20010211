package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.converters;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.EmployeeStatus;
import java.util.stream.Stream;
@Converter(autoApply = true)
public class EmployeeStatusConverter implements
    AttributeConverter<EmployeeStatus, Integer> {
        @Override
        public Integer convertToDatabaseColumn(EmployeeStatus attribute) {
            if (attribute == null) {
                return null;
            }
            return attribute.getValues();
        }
        @Override
        public EmployeeStatus convertToEntityAttribute(Integer dbData) {
            if (dbData == null) {
                return null;
            }
            return Stream.of(EmployeeStatus.values())
                    .filter(c -> c.getValues() == dbData)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
