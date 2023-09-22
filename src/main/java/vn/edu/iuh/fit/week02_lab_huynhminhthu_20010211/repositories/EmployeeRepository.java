package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.models.Employee;

public class EmployeeRepository {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public EmployeeRepository() {
        entityManager = Persistence
                .createEntityManagerFactory("www_lab02")
                .createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public void insertEmployee(Employee employee) {
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

    public void updateEmployee(Employee employee) {
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
        Employee employee = query.getSingleResult();
        return employee == null ? Optional.empty() : Optional.of(employee);
    }

    public List<Employee> getAllEmployee() {
        return entityManager.createNamedQuery("Employee.findAll", Employee.class)
                .setParameter(1, EmployeeStatus.ACTIVE)
                .getResultList();
    }
}
