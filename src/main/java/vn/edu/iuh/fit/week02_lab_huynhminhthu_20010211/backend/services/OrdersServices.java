package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services;


import jakarta.inject.Inject;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Order;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories.OrderRepository;

import java.util.List;

public class OrdersServices {
    @Inject
    private OrderRepository dao;

    @Inject
    public OrdersServices(OrderRepository orderDao) {
        this.dao = orderDao;
    }

    public List<Order> getAll() {
        return dao.getAll();
    }

    public Order searchById(long id) {
        return dao.searchById(id);
    }

    public List<Order> getFromXToY(int x, int y) {
        return dao.getFromXToY(x, y);
    }

    public boolean add(Order orders) {
        return dao.add(orders);
    }

    public boolean updateField(long id, String nameField, String newValue) {
        return dao.updateField(id, nameField, newValue);
    }

    public boolean del(long id) {
        return dao.del(id);
    }

}