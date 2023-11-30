package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services;


import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Employee;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeServices {
    private EmployeeRepository repository;

    public EmployeeServices() {
        repository = new EmployeeRepository();
    }
    public void insertEmp(Employee employee) {
        repository.insertEmployee(employee);
    }
    public  void updateEmp(Employee employee) {
        repository.update(employee);
    }

    public Optional<Employee> findById(long id) {
        return repository.findbyId(id);
    }

    public boolean delete(long id) {
        Optional<Employee> op = findById(id);
        if (op.isPresent()) {
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.TERMINATED);
            repository.update(employee);
            return true;
        }
        return false;
    }

    public boolean findbyId(long id) {
        Optional<Employee> op = findById(id);
        if (op.isPresent()) {
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public List<Employee> getAll() {
        return repository.getAllEmp();
    }
}