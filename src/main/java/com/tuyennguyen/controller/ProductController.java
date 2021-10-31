package com.tuyennguyen.controller;

import com.tuyennguyen.entity.Product;
import com.tuyennguyen.serivce.ProductService;
import com.tuyennguyen.util.HostName;
import com.tuyennguyen.util.UtilCon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class ProductController extends WebController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    private static final String mainObject = "product";

    @Autowired
    private ProductService mainService;

    @GetMapping(value = "/" + mainObject)
    public String getList(Model model) {
        logger.debug("Go to " + UtilCon.toAdmin(mainObject));
        setCommon(model);

        List<Product> listProduct = mainService.findAll();
        model.addAttribute("listProduct", listProduct);
        model.addAttribute(UtilCon.PAGE, UtilCon.PRODUCT);

        return UtilCon.toAdmin();
    }

    @GetMapping(value = "/" + mainObject + "/them")
    public String them(Model model) {
        logger.debug("Go to the add screen: " + UtilCon.toAdmin(mainObject));
        setCommon(model);

        model.addAttribute(UtilCon.OBJ, new Product());
        return UtilCon.toAdmin(mainObject, mainObject + "-them");
    }

    @PostMapping(value = "/" + mainObject + "/save")
    public ModelAndView save(@ModelAttribute(UtilCon.OBJ) Product product) {
        mainService.save(product);

        return new ModelAndView("redirect:" + HostName.LOCALHOST + "/admin/product");
    }

    @GetMapping(value = "/" + mainObject + "/edit/{id}")
    public String findById(@PathVariable int id, Model model) {
        setCommon(model);
        setListMenuDongCha(model, UtilCon.PARENT);

        Optional<Product> obj = mainService.findById(id);
        model.addAttribute(mainObject, obj);

        return UtilCon.toAdmin(mainObject, mainObject + "-edit");
    }

    @PostMapping(value = "/" + mainObject + "/update")
    public ModelAndView update(@ModelAttribute(mainObject) Product obj) {
        mainService.save(obj);

        return new ModelAndView("redirect:" + HostName.LOCALHOST + "/admin/product");
    }

    @GetMapping(value = "/" + mainObject + "/delete/{id}")
    public RedirectView delete(@PathVariable int id) {
        Optional<Product> obj = mainService.findById(id);

        mainService.deleteById(id);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(UtilCon.toAdmin(mainObject, mainObject));

        return redirectView;
    }
	
}
