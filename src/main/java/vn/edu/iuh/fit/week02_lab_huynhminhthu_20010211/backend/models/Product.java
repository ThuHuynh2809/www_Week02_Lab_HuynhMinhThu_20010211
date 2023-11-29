package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.ProductStatus;

import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Product.findAll", query = "select p from Product p where p.status = ?1"),
        @NamedQuery(name = "Product.findById", query = "select p from Product p where p.product_id = ?1")
})
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "varchar(150)")
    private String name;

    @Column(name = "description", columnDefinition = "varchar(250)")
    private String description;

    @Column(columnDefinition = "varchar(25)")
    private String unit;

    @Column(name = "manufacturer_name", columnDefinition = "varchar(100)")
    private String manufacturer;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "int")
    private ProductStatus status;

    // RELATIONSHIP
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> productImages = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductPrice> productPrices = new ArrayList<>();

    public Product() {
    }

    public Product(long id, String name, String description, String unit, String manufacturer, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.status = status;
    }

    public Product(String name, String description, String unit, String manufacturer, ProductStatus status) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.status = status;
    }

    public List<ProductImage> getProductImageList() {
        return productImages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", status=" + status +
                '}';
    }

}