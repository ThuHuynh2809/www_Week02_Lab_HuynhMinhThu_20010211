package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.ProductStatus;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;
    @Column(name = "name", length = 250, nullable = false)
    private String name;
    @Column(name = "description", length = 250, nullable = false)
    private String description;
    @Column(name = "unit", length = 250, nullable = false)
    private String unit;
    @Column(name = "manufacturer_name", length = 250, nullable = false)
    private String manufacturer_name;
    @Column(name = "status", nullable = false)
    private ProductStatus status;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JoinColumn
    private List<ProductImage> productImageList;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JoinColumn
    private List<ProductPrice> productPrices;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JoinColumn
    private List<OrderDetail> orderDetails;

    public Product(){

    }
    public Product(String name, String description, String unit, String manufacturer_name, ProductStatus status){
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer_name = manufacturer_name;
        this.status = status;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public List<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer_name='" + manufacturer_name + '\'' +
                ", status=" + status +
                '}';
    }
}
