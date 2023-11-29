//package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services;
//
//
//import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.EmployeeStatus;
//import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Employee;
//import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories.EmployeeRepository;
//
//import java.util.Optional;
//
//public class EmployeeServices {
//    private EmployeeRepository employeeRespository;
//
//    public EmployeeServices() {
//        employeeRespository = new EmployeeRepository();
//    }
//
//    public void insertEmployee(Employee employee) {
//        employeeRespository.insertEmployee(employee);
//    }
//
//    public boolean delete(long id) {
//        Optional<Employee> op = employeeRespository.findById(id);
//        if (op.isPresent()) {
//            Employee employee = op.get();
//            employee.setStatus(EmployeeStatus.IN_ACTIVE);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean activeEmp(long id) {
//        Optional<Employee> op = employeeRespository.findById(id);
//        if (op.isPresent()) {
//            Employee employee = op.get();
//            employee.setStatus(EmployeeStatus.ACTIVE);
//            return true;
//        }
//        return false;
//    }
//
//    public List<Employee> getAll() {
//        return employeeRespository.getAll();
//    }
//
//    public Optional<Employee> findById(long id) {
//        return employeeRespository.findById(id);
//    }
//
//}