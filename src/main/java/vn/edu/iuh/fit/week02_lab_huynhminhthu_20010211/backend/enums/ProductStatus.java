package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductStatus {
    ACTIVE(1),IN_ACTIVE(0),TERMINATED(-1);
    private int values;

    ProductStatus(int values) {
        this.values = values;
    }
    @JsonValue
    public int getValues() {
        return values;
    }

    @JsonCreator
    public static ProductStatus fromValue(int value) {
        for (ProductStatus status : ProductStatus.values()) {
            if (status.getValues() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid ProductStatus value: " + value);
    }

}
