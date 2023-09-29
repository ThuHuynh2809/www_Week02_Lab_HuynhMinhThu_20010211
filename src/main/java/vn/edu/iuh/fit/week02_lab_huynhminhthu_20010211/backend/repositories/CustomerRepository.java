package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Customer;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Employee;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public CustomerRepository() {
        entityManager = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public void insertCust(Customer customer) {
        try {
            entityTransaction.begin();
            entityManager.persist(customer);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public void setStatus(Employee employee, EmployeeStatus status) {
        employee.setStatus(status);
    }

    public void updateCust(Customer customer) {
        try {
            entityTransaction.begin();
            entityManager.merge(customer);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public Optional<Customer> findById(long id) {
        TypedQuery<Customer> typedQuery = entityManager.createQuery("select e from Customer e where e.id=:id", Customer.class);
        typedQuery.setParameter("id", id);
        Customer customer = typedQuery.getSingleResult();
        return customer == null ? Optional.empty() : Optional.of(customer);
    }

    public List<Customer> getAllCust() {
        return entityManager.createNamedQuery("Customer.getAll", Customer.class)
                .setParameter(1, EmployeeStatus.ACTIVE)
                .getResultList();
    }
}
