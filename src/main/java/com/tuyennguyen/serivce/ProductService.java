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
    private ProductRepository repository;

    public List<ProductMap> getListProductShowProductList() {
        return repository.getListProductShowProductList();
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Optional<Product> findById(int id) {
        return repository.findById(id);
    }

    public Product save(Product obj) {
        return repository.save(obj);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
