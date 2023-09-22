package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long image_Id;

    @Column(name = "path",nullable = false)
    private String path;

    @Column(name = "alternative")
    private String alternative;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductImage(){

    }
    public ProductImage(String path, String alternative){
        this.path = path;
        this.alternative = alternative;
    }

    public long getImage_Id() {
        return image_Id;
    }

    public void setImage_Id(long image_Id) {
        this.image_Id = image_Id;
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
        return "ProductImage{" +
                "image_Id=" + image_Id +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                ", product=" + product +
                '}';
    }
}
