package com.tuyennguyen.controller;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.entity.Product;
import com.tuyennguyen.entity.Setting;
import com.tuyennguyen.repository.MenuDongRepository;
import com.tuyennguyen.repository.ProductRepository;
import com.tuyennguyen.serivce.MenuDongService;
import com.tuyennguyen.util.UtilCon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientController extends WebController {

    Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private MenuDongService mainService;

    @Autowired
    private MenuDongRepository menuDongRepo;

    @Autowired
    private ProductRepository productRepo;

    private Setting setting;

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = {"/", "/home"})
    public String goHome(Model model, HttpServletRequest request) {
        String message = messageSource.getMessage("hello", null, "default message", request.getLocale());
        model.addAttribute("message", message);

        // log info
        log.debug("Go to: /, /home");

        try {
            String TITLE = "Trang Chủ";
            setCommon(model, TITLE);
            setSetting(model);

            List<MenuDong> listMenuDongIsVisible = mainService.findAllByIsVisible(UtilCon.VISIBLE);
            model.addAttribute("listMenuDongIsVisible", listMenuDongIsVisible);

            // get listProduct mặc định (yêu thích)
            setListProductFavo(model);

            // get list product theo menu
            setListProductMenu(model, UtilCon.EMPTY);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilCon.toClient("client");
    }

    @GetMapping({"/san-pham/{menuLink}"})
    public String showProduct(@PathVariable("menuLink") String menuLink, Model model) {
        // log info
        log.debug("Go to: /san-pham/" + menuLink);

        try {
            String TITLE = menuLink;
            setCommon(model, TITLE);
            setSetting(model);

            // get listProduct mặc định (yêu thích)
            setListProductFavo(model);

            // get list product theo menu
            setListProductMenu(model, menuLink);

            List<MenuDong> listMenuDongIsVisible = mainService.findAllByIsVisible(UtilCon.VISIBLE);
            model.addAttribute("listMenuDongIsVisible", listMenuDongIsVisible);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilCon.toClient("client");
    }

    @GetMapping("/lien-he")
    public String goLienHe(Model model) {
        // log info
        log.debug("Go to: /lien-he");

        try {
            String TITLE = "Liên Hệ";
            setCommon(model, TITLE);

            List<MenuDong> listMenuDong = mainService.findAll();
            model.addAttribute("listMenuDong", listMenuDong);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilCon.toClient("lien-he");
    }

    public void setListProductMenu(Model model, String menuLink) {
        if (UtilCon.EMPTY.equals(menuLink)) {
            model.addAttribute("listProductMenu", new ArrayList<>());
        } else {
            MenuDong menuDong = menuDongRepo.findMenuDongByMenuLink(menuLink);
            model.addAttribute("menuName", menuDong.getMenuName());

            int menuDongId = menuDong.getMenuDongId();
            List<Product> listProductMenu = productRepo.findProductsByMenuDongId(menuDongId);
            model.addAttribute("listProductMenu", listProductMenu);
        }
    }

    // get listProduct mặc định (yêu thích)
    public void setListProductFavo(Model model) {
        List<Product> listProductFavo = productRepo.findProductsByFavouriteAndIsVisible(1, 1);
        model.addAttribute("listProductFavo", listProductFavo);
    }

}
