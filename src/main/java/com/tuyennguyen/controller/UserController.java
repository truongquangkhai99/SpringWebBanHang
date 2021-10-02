package com.tuyennguyen.controller;

import com.tuyennguyen.entity.User;
import com.tuyennguyen.serivce.UserService;
import com.tuyennguyen.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = {"/", "trang-chu"})
    public String findAll() {
        return "home-page";
    }

    @GetMapping(value = "/{id}")
    public Optional<User> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping(value = "/save")
    public User save(@RequestBody User user) {
        return service.save(user);
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
