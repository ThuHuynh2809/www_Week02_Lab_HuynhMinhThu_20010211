package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long order_Id;
    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employeee employeee;

    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    public Order(){

    }
    public Order(long order_Id, LocalDateTime orderDate, Employee employee, Customer customer){
        this.order_Id = order_Id;
        this.orderDate = orderDate;
        this.employeee = employee;
        this.customer = customer;
    }

    public long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(long order_Id) {
        this.order_Id = order_Id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Employeee getEmployeee() {
        return employeee;
    }

    public void setEmployeee(Employeee employeee) {
        this.employeee = employeee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_Id=" + order_Id +
                ", orderDate=" + orderDate +
                ", employeee=" + employeee +
                ", customer=" + customer +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
