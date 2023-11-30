package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Customer;


import java.util.List;

public class CustomerRepository {
    private EntityManager em;
    private EntityTransaction trans;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CustomerRepository() {
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        trans = em.getTransaction();
    }

    public void add(Customer customer) {
        try {
            trans.begin();
            em.persist(customer);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }

    public List<Customer> getAll() {
        return em.createNamedQuery("Customer.getAll", Customer.class).getResultList();
    }
}