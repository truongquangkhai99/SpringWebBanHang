package com.tuyennguyen.controller;

import com.tuyennguyen.entity.Product;
import com.tuyennguyen.serivce.ProductService;
import com.tuyennguyen.util.StatusEnum;
import com.tuyennguyen.util.UtilCon;
import com.tuyennguyen.util.UtilFun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class ProductController extends WebController {

    private final String PRODUCT = "product";

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product")
    public String getList(Model model) {
        setHost(model);
        setBootstrap(model);

        List<Product> listProduct = productService.findAll();
        model.addAttribute("listProduct", listProduct);

        return UtilFun.toAdmin(PRODUCT);
    }

    @GetMapping(value = "/product/edit/{id}")
    public String findById(@PathVariable int id, Model model) {
        setBootstrap(model);

        Optional<Product> obj = productService.findById(id);
        model.addAttribute(PRODUCT, obj);

        return UtilFun.toAdmin("product-edit");
    }

    @GetMapping(value = "/product/them")
    public String them(@RequestBody Product obj) {
        return PRODUCT + UtilCon.Dash + "them";
    }

    @PostMapping(value = "/product/save")
    public Product save(@RequestBody Product obj) {
        return productService.save(obj);
    }


    @GetMapping(value = "/product/delete/{id}")
    public RedirectView delete(@PathVariable int id) {
        Optional<Product> obj = productService.findById(id);

        productService.deleteById(id);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(UtilFun.toAdmin(PRODUCT));

        return redirectView;
    }
	
}
