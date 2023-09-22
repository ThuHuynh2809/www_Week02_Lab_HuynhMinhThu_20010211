package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.models;

import jakarta.persistence.*;

@Entity
@Table(name = "orderDetail")
public class OrderDetail {

    @Column(name = "quantily", nullable = false)
    private long quantily;
    @Column(name = "price",nullable = false)
    private double price;
    @Column(name = "note",length = 255, nullable = false)
    private String note;

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderDetail(){

    }
    public OrderDetail(long quantily, double price, String note, Order order, Product product){
        this.quantily = quantily;
        this.price = price;
        this.note = note;
        this.order = order;
        this.product = product;
    }

    public long getQuantily() {
        return quantily;
    }

    public void setQuantily(long quantily) {
        this.quantily = quantily;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "quantily=" + quantily +
                ", price=" + price +
                ", note='" + note + '\'' +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}
