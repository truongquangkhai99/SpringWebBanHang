package com.tuyennguyen.controller;

import com.tuyennguyen.entity.Product;
import com.tuyennguyen.entity.User;
import com.tuyennguyen.serivce.ProductService;
import com.tuyennguyen.serivce.UserService;
import com.tuyennguyen.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/", "trang-chu"})
    public String findAll(Model model) {
        List<Product> listProduct = productService.findAll();
        model.addAttribute("listProduct", listProduct);

        return "home-page";
    }

    @GetMapping(value = "/{id}")
    public Optional<User> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping(value = "/save")
    public User save(@RequestBody User obj) {
        return service.save(obj);
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        Optional<User> user = service.findById(id);

        if (user.isEmpty()) {
            return Status.NOT_EXIST.getValue();
        }

        service.deleteById(id);
        return Status.SUCCESS.getValue();
    }
	
}
