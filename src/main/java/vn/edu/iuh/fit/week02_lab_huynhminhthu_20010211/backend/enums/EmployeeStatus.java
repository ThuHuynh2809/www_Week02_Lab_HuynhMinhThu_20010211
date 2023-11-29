package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EmployeeStatus {
    ACTIVE(1), IN_ACTIVE(0), TERMINATED(-1);
    private int value;

    EmployeeStatus(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValues() {
        return value;
    }

    @JsonCreator
    public static EmployeeStatus fromValue(int value) {
        for (EmployeeStatus status : EmployeeStatus.values()) {
            if (status.getValues() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid EmployeeStatus value: " + value);
    }
}
