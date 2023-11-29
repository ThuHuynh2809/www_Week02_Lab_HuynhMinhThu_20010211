package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.OrderDetail;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.ProductPrice;

import java.util.List;


public class OrderDetailRepository {
    private EntityManager em;
    private ProductPriceRepository productPriceDao = new ProductPriceRepository();
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public OrderDetailRepository() {
        em = DBConnect.getInstance().getEmf().createEntityManager();
    }

    public OrderDetail searchById(OrderDetail id) {
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();

            OrderDetail orderDetail = em.find(OrderDetail.class, id);

            tr.commit();
            return orderDetail;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public List<OrderDetail> getAll(long order_id) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            List<OrderDetail> list = em
                    .createNativeQuery("select * from order_detail where order_id = " + order_id, OrderDetail.class)
                    .getResultList();

            tr.commit();
            return list;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public boolean add(OrderDetail orderDetail) {
        EntityTransaction tr = em.getTransaction();
        OrderDetail id = new OrderDetail(orderDetail.getOrder(), orderDetail.getProduct());
        OrderDetail temp = searchById(id);
        try {
            tr.begin();
            if (temp != null)
                return false;
            else {
                List<ProductPrice> fromXToY = productPriceDao.getFromXToY(orderDetail.getProduct().getId(), 1, 1);
                orderDetail.setPrice(fromXToY.get(0).getPrice());
                em.persist(orderDetail);
            }
            tr.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }
    public boolean del(OrderDetail id) {
        EntityTransaction tr = em.getTransaction();
        OrderDetail orderDetail = searchById(id);
        if (orderDetail == null)
            return false;
        try {
            tr.begin();

            em.remove(orderDetail);

            tr.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }
}
