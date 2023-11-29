package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.OrderDetail;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories.OrderDetailRepository;

import java.util.List;

public class OrderDetailService {
    @Inject
    private OrderDetailRepository daoResponsitory;

    @Inject
    public OrderDetailService(OrderDetailRepository orderDetailResponsitory) {
        this.daoResponsitory = orderDetailResponsitory;
    }

    public OrderDetail searchById(OrderDetail orderDetail) {
        return daoResponsitory.searchById(orderDetail);
    }

    public List<OrderDetail> getAll(long orders_id) {
        return daoResponsitory.getAll(orders_id);
    }

    public boolean add(OrderDetail obj) {
        return daoResponsitory.add(obj);
    }

    public boolean del(OrderDetail obj) {
        return daoResponsitory.del(obj);
    }
}
