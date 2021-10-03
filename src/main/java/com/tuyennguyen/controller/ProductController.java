package com.tuyennguyen.controller;

import com.tuyennguyen.entity.Product;
import com.tuyennguyen.serivce.ProductService;
import com.tuyennguyen.util.FolderNameEnum;
import com.tuyennguyen.util.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class ProductController extends WebController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public String getList(Model model) {
        setModelBootstrapCss(model);

        List<Product> listProduct = productService.findAll();
        model.addAttribute("listProduct", listProduct);

        return FolderNameEnum.ADMIN.getValue() + "/product";
    }

    @GetMapping(value = "/product/edit/{id}")
    public String findById(@PathVariable int id, Model model) {
        setModelBootstrapCss(model);

        Optional<Product> obj = productService.findById(id);
        model.addAttribute("product", obj);

        return FolderNameEnum.ADMIN.getValue() + "/product-edit";
    }

    @PostMapping(value = "/product/save")
    public Product save(@RequestBody Product obj) {
        return productService.save(obj);
    }

    @GetMapping(value = "/product/delete/{id}")
    public String delete(@PathVariable int id) {
        Optional<Product> obj = productService.findById(id);

        if (obj.isEmpty()) {
            return StatusEnum.NOT_EXIST.getValue();
        }

        productService.deleteById(id);
        return StatusEnum.SUCCESS.getValue();
    }
	
}
