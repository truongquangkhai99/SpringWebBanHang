package com.tuyennguyen.controller;

import com.tuyennguyen.entity.Product;
import com.tuyennguyen.serivce.ProductService;
import com.tuyennguyen.util.UtilCon;
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
    private static final String mainObject = "product";

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/" + mainObject)
    public String getList(Model model) {
        logger.debug("Go to " + UtilCon.toAdmin(mainObject));
        setCommon(model);

        List<Product> listProduct = productService.findAll();
        model.addAttribute("list" + UtilCon.upperFirstLetter(mainObject), listProduct);

        return UtilCon.toAdmin(mainObject);
    }

    @GetMapping(value = "/" + mainObject + "/them")
    public String them(Model model) {
        logger.debug("Go to the add screen: " + UtilCon.toAdmin(mainObject));
        setCommon(model);

        model.addAttribute(UtilCon.OBJ, new Product());
        return UtilCon.toAdmin(mainObject + "-them");
    }

    @PostMapping(value = "/" + mainObject + "/save")
    public RedirectView save(@ModelAttribute(UtilCon.OBJ) Product product) {
        productService.save(product);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(UtilCon.toAdmin(mainObject));

        return redirectView;
    }

    @GetMapping(value = "/" + mainObject + "/edit/{id}")
    public String findById(@PathVariable int id, Model model) {
        setCommon(model);

        Optional<Product> obj = productService.findById(id);
        model.addAttribute(mainObject, obj);

        return UtilCon.toAdmin(mainObject + "-edit");
    }

    @GetMapping(value = "/" + mainObject + "/delete/{id}")
    public RedirectView delete(@PathVariable int id) {
        Optional<Product> obj = productService.findById(id);

        productService.deleteById(id);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(UtilCon.toAdmin(mainObject));

        return redirectView;
    }
	
}
