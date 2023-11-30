package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services;

import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Customer;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories.CustomerRepository;

import java.util.List;
public class CustomerServices {
    private final CustomerRepository repository = new CustomerRepository();

    public CustomerServices() {
//        repository = new CustomerRepository();
    }

    public void insertCust(Customer customer) {
        repository.add(customer);
    }

    public List<Customer> getAll() {
        return repository.getAll();
    }
}