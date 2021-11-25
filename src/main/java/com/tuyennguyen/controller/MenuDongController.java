package com.tuyennguyen.controller;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.repository.MenuDongRepository;
import com.tuyennguyen.serivce.MenuDongService;
import com.tuyennguyen.util.UtilHost;
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
public class MenuDongController extends WebController {

    Logger logger = LoggerFactory.getLogger(MenuDongController.class);
    private static final String MAIN_OBJECT = "menu-dong";

    @Autowired
    private MenuDongService mainService;

    @Autowired
    private MenuDongRepository menuDongRepo;

    @GetMapping(value = "/" + MAIN_OBJECT)
    public String showList(Model model) {
        logger.debug("Go to " + UtilCon.toAdmin(MAIN_OBJECT));
        setCommon(model);

        List<MenuDong> listMenuDong = mainService.findAll();
        model.addAttribute("listMenuDong", listMenuDong);

        model.addAttribute(UtilCon.PAGE, UtilCon.MENU_DONG);

        return UtilCon.toAdmin();
    }

    @GetMapping(value = "/" + MAIN_OBJECT + "/them")
    public String them(Model model) {
        logger.debug("Go to the add screen: " + UtilCon.toAdmin(MAIN_OBJECT, MAIN_OBJECT + "/them"));
        setCommon(model);

        model.addAttribute(UtilCon.OBJ, new MenuDong());
        model.addAttribute(UtilCon.PAGE, UtilCon.MENU_DONG_THEM);
        return UtilCon.toAdmin();
    }

    @PostMapping(value = "/" + MAIN_OBJECT + "/save")
    public ModelAndView save(@ModelAttribute(UtilCon.OBJ) MenuDong obj) {
        obj = UtilCon.trimObject(obj);
        String menuLink = UtilCon.createLinkFromMenuName(obj.getMenuName());
        obj.setMenuLink(menuLink);

        String PAGE = "";
        int count = menuDongRepo.countMenuDongByMenuName(obj.getMenuName());
        System.out.println(count);
        // if count > 0, not save more
        if (count > 0) {
            PAGE = "menu-dong/them";
        } else {
            PAGE = "menu-dong";
            mainService.save(obj);
        }

        return new ModelAndView("redirect:" + UtilHost.LOCALHOST + "/admin/" + PAGE);
    }

    @GetMapping(value = "/" + MAIN_OBJECT + "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        setCommon(model);

        Optional<MenuDong> obj = mainService.findById(id);
        model.addAttribute("menuDong", obj);
        model.addAttribute(UtilCon.PAGE, UtilCon.MENU_DONG_EDIT);

        return UtilCon.toAdmin();
    }

    @PostMapping(value = "/" + MAIN_OBJECT + "/update")
    public ModelAndView update(@ModelAttribute(MAIN_OBJECT) MenuDong obj) {
        obj = UtilCon.trimObject(obj);
        String menuLink = UtilCon.createLinkFromMenuName(obj.getMenuName());
        obj.setMenuLink(menuLink);

        mainService.save(obj);

        return new ModelAndView("redirect:" + UtilHost.LOCALHOST + "/admin/menu-dong");
    }

    @GetMapping(value = "/" + MAIN_OBJECT + "/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        mainService.deleteById(id);

        return new ModelAndView("redirect:" + UtilHost.LOCALHOST + "/admin/" + MAIN_OBJECT);
    }
	
}
