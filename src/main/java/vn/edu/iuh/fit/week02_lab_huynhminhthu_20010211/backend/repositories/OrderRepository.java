package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Order;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRepository {
    private EntityManager em = null;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private CustomerRepository customerDao = new CustomerRepository();
    private EmployeeRepository employeeDao = new EmployeeRepository();

    public OrderRepository() {
        this.em = DBConnect.getInstance().getEmf().createEntityManager();
    }

    public List<Order> getAll() {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            List<Order> list = em.createNativeQuery("SELECT * from orders ORDER BY DESC order_date", Order.class)
                    .getResultList();

            tr.commit();
            return list;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public Order searchById(long id) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            Order orders = em.find(Order.class, id);

            tr.commit();
            return orders;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public List<Order> getFromXToY(int x, int y) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            int from = y - x + 1;
            int to = x - 1;

            String sql = "SELECT * FROM orders ORDER BY order_date DESC LIMIT " + from + " OFFSET " + to;

            List<Order> list = em.createNativeQuery(sql, Order.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public boolean add(Order orders) {
        EntityTransaction tr = em.getTransaction();
        Order temp = searchById(orders.getId());
        try {
            tr.begin();
            em.merge(orders);
            tr.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

    public boolean updateField(long id, String nameField, String newValue) {
        EntityTransaction tr = em.getTransaction();
        Order orders = searchById(id);
        if (orders == null)
            return false;
        try {
            tr.begin();
            switch (nameField) {
                case "orderDate":
                    orders.setOrderDate(LocalDateTime.parse(newValue));
                    break;
                case "employee":
                    orders.setEmployee(employeeDao.searchById(Long.parseLong(newValue)));
                    break;
                case "customer":
                    orders.setCustomer(customerDao.searchById(Long.parseLong(newValue)));
                    break;

            }
            tr.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

    public boolean del(long id) {
        EntityTransaction tr = em.getTransaction();
        Order orders = searchById(id);
        if (orders == null)
            return false;
        try {
            tr.begin();

            em.remove(orders);

            tr.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

}
