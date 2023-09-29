package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long order_Id;
    @Column(name = "order_date", nullable = false)
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    public Order(){

    }

    public Order(long order_Id, LocalDate orderDate, Employee employee, Customer customer, List<OrderDetail> orderDetails) {
        this.order_Id = order_Id;
        this.orderDate = orderDate;
        this.employee = employee;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }

    public long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(long order_Id) {
        this.order_Id = order_Id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
                ", employee=" + employee +
                ", customer=" + customer +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
