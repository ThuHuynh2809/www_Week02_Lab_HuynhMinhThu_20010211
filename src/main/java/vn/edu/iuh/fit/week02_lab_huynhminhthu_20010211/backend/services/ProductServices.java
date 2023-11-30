package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services;

import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.ProductStatus;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Product;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.repositories.ProductRepository;

import java.util.List;

public class ProductServices {
    private final ProductRepository repository;

    public ProductServices() {
        repository=new ProductRepository();
    }

    public void insert(Product product){
        repository.add(product);
    }

    public List<Product> getActiveProducts(){
        return repository.getActiveProduct();
    }

    public void updateStatus(long id, ProductStatus status) {
        repository.updateStatus(id,status);
    }
}