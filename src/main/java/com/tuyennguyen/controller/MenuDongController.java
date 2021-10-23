package com.tuyennguyen.controller;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.entity.Product;
import com.tuyennguyen.serivce.MenuDongService;
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
public class MenuDongController extends WebController {

    Logger logger = LoggerFactory.getLogger(MenuDongController.class);
    private static final String mainObject = "menu-dong";

    @Autowired
    private MenuDongService mainService;

    @GetMapping(value = "/" + mainObject)
    public String getList(Model model) {
        logger.debug("Go to " + UtilCon.toAdmin(mainObject));
        setCommon(model);

        List<MenuDong> listMenuDong = mainService.findAll();
        model.addAttribute("listMenuDong", listMenuDong);
        System.out.println("Menu động");
        System.out.println(listMenuDong);

        return UtilCon.toAdmin(mainObject);
    }

    @GetMapping(value = "/" + mainObject + "/them")
    public String them(Model model) {
        logger.debug("Go to the add screen: " + UtilCon.toAdmin(mainObject));
        setCommon(model);

        model.addAttribute(UtilCon.OBJ, new MenuDong());
        return UtilCon.toAdmin(mainObject + "-them");
    }

    @PostMapping(value = "/" + mainObject + "/save")
    public RedirectView save(@ModelAttribute(UtilCon.OBJ) MenuDong menuDong) {
        mainService.save(menuDong);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(UtilCon.toAdmin(mainObject));

        return redirectView;
    }

    @GetMapping(value = "/" + mainObject + "/edit/{id}")
    public String findById(@PathVariable int id, Model model) {
        setCommon(model);

        Optional<MenuDong> obj = mainService.findById(id);
        model.addAttribute("menuDong", obj);

        return UtilCon.toAdmin(mainObject + "-edit");
    }

    @PostMapping(value = "/" + mainObject + "/update")
    public RedirectView update(@ModelAttribute(mainObject) MenuDong obj) {
        mainService.save(obj);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(UtilCon.toAdmin(mainObject));

        return redirectView;
    }

    @GetMapping(value = "/" + mainObject + "/delete/{id}")
    public RedirectView delete(@PathVariable int id) {
        Optional<MenuDong> obj = mainService.findById(id);

        mainService.deleteById(id);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(UtilCon.toAdmin(mainObject));

        return redirectView;
    }
	
}
