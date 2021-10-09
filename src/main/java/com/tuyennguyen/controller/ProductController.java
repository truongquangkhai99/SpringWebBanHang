package com.tuyennguyen.controller;

import com.tuyennguyen.entity.Product;
import com.tuyennguyen.serivce.ProductService;
import com.tuyennguyen.util.UtilCon;
import com.tuyennguyen.util.UtilFun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class ProductController extends WebController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final String PRODUCT = "product";

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product")
    public String getList(Model model) {
        logger.debug("Go to " + UtilFun.toAdmin(PRODUCT));
        setCommon(model);

        List<Product> listProduct = productService.findAll();
        model.addAttribute("listProduct", listProduct);

        return UtilFun.toAdmin(PRODUCT);
    }

    @GetMapping(value = "/product/edit/{id}")
    public String findById(@PathVariable int id, Model model) {
        setCommon(model);

        Optional<Product> obj = productService.findById(id);
        model.addAttribute(PRODUCT, obj);

        return UtilFun.toAdmin("product-edit");
    }

    @GetMapping(value = "/product/them")
    public String them(Model model) {
        logger.debug("Go to the add screen: " + UtilFun.toAdmin(PRODUCT));
        setCommon(model);

        model.addAttribute(UtilCon.OBJ, new Product());
        return UtilFun.toAdmin(PRODUCT + "-them");
    }

    @PostMapping(value = "/product/save")
    public RedirectView save(@ModelAttribute(UtilCon.OBJ) Product product) {
        productService.save(product);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(UtilFun.toAdmin(PRODUCT));

        return redirectView;
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
