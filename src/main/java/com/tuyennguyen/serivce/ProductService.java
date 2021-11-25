package com.tuyennguyen.serivce;

import com.tuyennguyen.entity.Product;
import com.tuyennguyen.model.mapping.ProductMap;
import com.tuyennguyen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public List<ProductMap> getListProductShowProductList() {
        return productRepo.getListProductShowProductList();
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Optional<Product> findById(int id) {
        return productRepo.findById(id);
    }

    public Product save(Product obj) {
        return productRepo.save(obj);
    }

    public void deleteById(int id) {
        productRepo.deleteById(id);
    }

}
