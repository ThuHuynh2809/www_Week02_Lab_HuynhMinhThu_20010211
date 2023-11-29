package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.ProductStatus;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Product;

import java.util.List;

public class ProductRepository {

    private EntityManager em = null;
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductRepository() {
        this.em = DBConnect.getInstance().getEmf().createEntityManager();
    }

    public List<Product> getAll() {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            List<Product> list = em
                    .createNativeQuery("SELECT * from product where status = 2 OR status = 1 ORDER BY name",
                            Product.class)
                    .getResultList();

            tr.commit();
            return list;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public Product searchById(long id) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            Product product = em.find(Product.class, id);

            tr.commit();
            return product;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public List<Product> getFromXToY(int x, int y) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();

            int from = y - x + 1;
            int to = x - 1;

            String sql = "SELECT * FROM product  where status = 2 OR status = 1 ORDER BY name LIMIT " + from
                    + " OFFSET " + to;

            List<Product> list = em.createNativeQuery(sql, Product.class).getResultList();

            tr.commit();
            return list;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return null;
    }

    public boolean add(Product product) {
        EntityTransaction tr = em.getTransaction();
        Product temp = searchById(product.getId());
        try {
            tr.begin();
            em.merge(product);
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
        Product product = searchById(id);
        if (product == null)
            return false;
        try {
            tr.begin();
            switch (nameField) {
                case "name":
                    product.setName(newValue);
                    break;
                case "description":
                    product.setDescription(newValue);
                    break;
                case "unit":
                    product.setUnit(newValue);
                    break;
                case "manufacturer":
                    product.setManufacturer(newValue);
                    break;
                case "status":
                    if (newValue.equals("-1")) {
                        product.setStatus(ProductStatus.TERMINATED);
                    } else if (newValue.equals("0")) {
                        product.setStatus(ProductStatus.IN_ACTIVE);
                    } else
                        product.setStatus(ProductStatus.ACTIVE);
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
        Product product = searchById(id);
        if (product == null)
            return false;
        try {
            tr.begin();

            product.setStatus(ProductStatus.TERMINATED);

            tr.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            tr.rollback();
        }
        return false;
    }

    public void updateStatus(long id, ProductStatus status) {
        EntityTransaction tr = em.getTransaction();
        TypedQuery<Product> q = em.createNamedQuery("Product.findById", Product.class)
                .setParameter(1, id);
        Product product = q.getSingleResult();
        product.setStatus(status);
        try {
            tr.begin();
            em.merge(product);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            logger.error(e.getMessage());
        }
    }

    public List<Product> getActiveProduct(){
        return em.createNamedQuery("Product.findAll",Product.class)
                .setParameter(1, ProductStatus.ACTIVE)
                .getResultList();
    }
}