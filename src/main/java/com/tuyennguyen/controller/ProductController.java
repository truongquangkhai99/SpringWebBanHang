package com.tuyennguyen.controller;

import com.tuyennguyen.entity.Product;
import com.tuyennguyen.serivce.ProductService;
import com.tuyennguyen.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/products")
    public String findById() {
        return "product";
    }

    @GetMapping(value = "/product/{id}")
    public Optional<Product> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping(value = "/product/save")
    public Product save(@RequestBody Product obj) {
        return service.save(obj);
    }

    @GetMapping(value = "/product/delete/{id}")
    public String delete(@PathVariable int id) {
        Optional<Product> obj = service.findById(id);

        if (obj.isEmpty()) {
            return Status.NOT_EXIST.getValue();
        }

        service.deleteById(id);
        return Status.SUCCESS.getValue();
    }
	
}
