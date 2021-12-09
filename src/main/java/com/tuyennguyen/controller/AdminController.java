package com.tuyennguyen.controller;

import com.tuyennguyen.entity.Product;
import com.tuyennguyen.entity.User;
import com.tuyennguyen.serivce.ProductService;
import com.tuyennguyen.serivce.UserService;
import com.tuyennguyen.util.UtilCon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController extends WebController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    Logger log = LoggerFactory.getLogger(AdminController.class);
    private static final String mainObject = "admin";

    @GetMapping(value = "/admin-login")
    public String login(Model model) {
        // log info
        log.debug("Go to " + UtilCon.goAdmin());

        try {
            setCommon(model);
        } catch (Exception e) {
            log.error("", e);
        }

        return UtilCon.toAdmin("admin-login");
    }

    @GetMapping(value = "/admin")
    public String admin(Model model) {
        // log info
        log.debug("Go to " + UtilCon.goAdmin());

        try {
            setCommon(model);

    //        List<Product> listProduct = productService.findAll();
            List<Product> listProduct = null;
            model.addAttribute("listProduct", listProduct);
            model.addAttribute("page", "product");

            List<User> listUser = userService.findAll();
            model.addAttribute("listUser", listUser);
        } catch (Exception e) {
            log.error("", e);
        }

        return UtilCon.goAdmin();
    }

}
