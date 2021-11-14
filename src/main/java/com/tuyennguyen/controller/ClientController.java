package com.tuyennguyen.controller;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.entity.Product;
import com.tuyennguyen.repository.MenuDongRepository;
import com.tuyennguyen.repository.ProductRepository;
import com.tuyennguyen.serivce.MenuDongService;
import com.tuyennguyen.util.UtilCon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController extends WebController {

    Logger logger = LoggerFactory.getLogger(ClientController.class);
    private static final String mainObject = "client";

    @Autowired
    private MenuDongService mainService;

    @Autowired
    private MenuDongRepository menuDongRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = {"/", "/home"})
    public String goHome(Model model) {
        logger.debug("Go to " + UtilCon.toClient("home"));
        setCommon(model);

        List<MenuDong> listMenuDongIsVisible = mainService.findAllByIsVisible(UtilCon.VISIBLE);
        model.addAttribute("listMenuDongIsVisible", listMenuDongIsVisible);

        // get listProduct mặc định (yêu thích)
        List<Product> listProductFavo = productRepository.findProductsByFavouriteAndVisible(1, 1);
        model.addAttribute("listProductFavo", listProductFavo);

        return UtilCon.toClient(mainObject);
    }

    @GetMapping(value = {"/san-pham/{url}"})
    public String showProduct(@PathVariable("url") String url, Model model) {
        logger.debug("Go to " + UtilCon.toClient("pathProduct"));
        setCommon(model);
        System.out.println(UtilCon.toClient(mainObject));

        // từ url của menu, get menuDongId
        int menuDongId = menuDongRepository.findMenuDongByUrl(url).getMenuDongId();
        System.out.println(menuDongId);

        // từ menuDongId, get tbl_product.*
        List<Product> listProduct = productRepository.findProductsByMenuDongId(menuDongId);
        model.addAttribute("listProduct", listProduct);

        List<MenuDong> listMenuDongIsVisible = mainService.findAllByIsVisible(UtilCon.VISIBLE);
        model.addAttribute("listMenuDongIsVisible", listMenuDongIsVisible);

        return UtilCon.toClient(mainObject);
    }

    @GetMapping(value = "/lien-he")
    public String goLienHe(Model model) {
        logger.debug("Go to " + UtilCon.toClient("lien-he"));
        setCommon(model);

        List<MenuDong> listMenuDong = mainService.findAll();
        model.addAttribute("listMenuDong", listMenuDong);

        return UtilCon.toClient("lien-he");
    }
	
}
