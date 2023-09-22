package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.enums;

public enum ProductStatus {
    ACTIVE(1),IN_ACTIVE(0),TERMINATED(-1);
    private int value;
    ProductStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
