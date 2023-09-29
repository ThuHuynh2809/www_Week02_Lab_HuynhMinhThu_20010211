package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @Column(name = "price_date_time")
    private LocalDateTime price_date_time;

    @Column(name = "price")
    private double price;

    @Column(name = "note")
    private String note;

    @Id
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    public ProductPrice(){

    }
    public ProductPrice(LocalDateTime price_date_time, double price, String note, Product product){
        this.price_date_time = price_date_time;
        this.price = price;
        this.note = note;
        this.product = product;

    }

    public LocalDateTime getPrice_date_time() {
        return price_date_time;
    }

    public void setPrice_date_time(LocalDateTime price_date_time) {
        this.price_date_time = price_date_time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "price_date_time=" + price_date_time +
                ", price=" + price +
                ", note='" + note + '\'' +
                ", product=" + product +
                '}';
    }
}
