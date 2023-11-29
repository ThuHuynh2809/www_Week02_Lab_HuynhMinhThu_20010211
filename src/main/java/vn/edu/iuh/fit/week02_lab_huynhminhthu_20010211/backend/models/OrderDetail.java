package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Column(name = "quantity", columnDefinition = "double")
    private Double quantity;

    @Column(name = "price", columnDefinition = "double")
    private Double price;

    @Column(name = "note", columnDefinition = "varchar(250)")
    private String note;

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public OrderDetail(Double quantity, Double price, String note, Order order, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.note = note;
        this.order = order;
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
                "quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                ", orders=" + order +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof OrderDetail))
            return false;
        OrderDetail that = (OrderDetail) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}