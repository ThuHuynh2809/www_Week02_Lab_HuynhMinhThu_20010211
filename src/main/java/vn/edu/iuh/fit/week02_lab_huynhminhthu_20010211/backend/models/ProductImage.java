package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private long image_id;

    @Column(name = "path", columnDefinition = "varchar(250)")
    private String path;

    @Column(name = "alternative", columnDefinition = "varchar(250)")
    private String alternative;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    public ProductImage() {
    }

    public ProductImage(long image_id, String path, String alternative, Product product) {
        this.image_id = image_id;
        this.path = path;
        this.alternative = alternative;
        this.product = product;
    }

    public ProductImage(String path, String alternative, Product product) {
        this.path = path;
        this.alternative = alternative;
        this.product = product;
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductImage [image_id=" + image_id + ", path=" + path + ", alternative=" + alternative + ", product="
                + product + "]";
    }

}