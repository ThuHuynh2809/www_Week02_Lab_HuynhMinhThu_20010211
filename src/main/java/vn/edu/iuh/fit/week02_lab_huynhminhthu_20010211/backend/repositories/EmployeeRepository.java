package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public EmployeeRepository() {
        entityManager = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public void insertEmp(Employee employee) {
        try {
            entityTransaction.begin();
            entityManager.persist(employee);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public void setStatus(Employee employee, EmployeeStatus status) {
        employee.setStatus(status);
    }

    public void updateEmp(Employee employee) {
        try {
            entityTransaction.begin();
            entityManager.merge(employee);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public Optional<Employee> findById(long id) {
        TypedQuery<Employee> typedQuery = entityManager.createQuery("select e from Employee e where e.id=:id", Employee.class);
        typedQuery.setParameter("id", id);
        Employee employee = typedQuery.getSingleResult();
        return employee == null ? Optional.empty() : Optional.of(employee);
    }

    public List<Employee> getAllEmp() {
        return entityManager.createNamedQuery("Employee.getAll", Employee.class)
                .setParameter(1, EmployeeStatus.ACTIVE)
                .getResultList();
    }
}
