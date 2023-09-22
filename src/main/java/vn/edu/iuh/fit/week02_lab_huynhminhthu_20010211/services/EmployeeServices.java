package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.services;

import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.models.Employee;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeServices {
    private EmployeeRepository employeeRepository;
    public EmployeeServices(){
        employeeRepository = new EmployeeRepository();
    }
    public List<Employee> getAll(){
        return employeeRepository.getAllEmployee();
    }
    public Optional<Employee> findById(long id){
        return employeeRepository.findById(id);
    }
    public void insertEmployee(Employee employee){
        employeeRepository.insertEmployee(employee);
    }
    public boolean deleteEmployee(long id){
        Optional<Employee> optionalEmployee = findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setStatus(EmployeeStatus.TERMINATED);
            return true;
        }
        return false;
    }
    public boolean activeEmployee(long id){
        Optional<Employee> optionalEmployee = findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }
}
