package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services;

import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Employee;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeServices {
    private EmployeeRepository employeeRepository;
    public EmployeeServices(){
        employeeRepository = new EmployeeRepository();
    }
    public List<Employee> getAll(){
        return employeeRepository.getAllEmp();
    }
    public Optional<Employee> findById(long id){
        return employeeRepository.findById(id);
    }
    public void insertEmp(Employee employee){
        employeeRepository.insertEmp(employee);
    }
    public boolean deleteEmp(long id){
        Optional<Employee> optionalEmployee = findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setStatus(EmployeeStatus.TERMINATED);
            return true;
        }
        return false;
    }
    public boolean activeEmp(long id){
        Optional<Employee> optionalEmployee = findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }

}
