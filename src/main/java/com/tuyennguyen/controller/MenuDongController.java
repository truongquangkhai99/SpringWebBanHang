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

@Controller
@RequestMapping("/admin")
public class MenuDongController extends WebController {

    Logger log = LoggerFactory.getLogger(MenuDongController.class);

    private static final String MENU_DONG = "menu-dong";

    @Autowired
    private MenuDongService menuDongService;

    @Autowired
    private MenuDongRepository menuDongRepo;

    @Override
    public void setListMenuDong(Model model) {
        super.setListMenuDong(model);
    }

    @GetMapping(value = "/" + MENU_DONG)
    public String showList(Model model) {
        // log info
        log.debug("Go to: /admin/menu-dong");

        try {
            // backup db
            UtilCon.backUpDb();
            // set host, bootstrap
            setCommon(model);
            //set list
            setListMenuDong(model);

            //set page
            model.addAttribute(UtilCon.PAGE, UtilCon.MENU_DONG);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilCon.goAdmin();
    }

    @GetMapping(value = "/" + MENU_DONG + "/them")
    public String them(Model model) {
        // log info
        log.debug("Go to: /admin/menu-dong/them");

        try {
            // set host, bootstrap
            setCommon(model);

            model.addAttribute(UtilCon.OBJ, new MenuDong());
            model.addAttribute(UtilCon.PAGE, UtilCon.MENU_DONG_THEM);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilCon.goAdmin();
    }

    @PostMapping(value = "/" + MENU_DONG + "/save")
    public ModelAndView save(@ModelAttribute(UtilCon.OBJ) MenuDong obj) {
        // log info
        log.debug("Go to: /admin/menu-dong/save/" + obj.getMenuDongId());

        String PAGE = "";

        try {
            obj = UtilCon.trimObject(obj);
            String menuLink = UtilCon.createLinkFromMenuName(obj.getMenuName());
            obj.setMenuLink(menuLink);

            int count = menuDongRepo.countMenuDongByMenuName(obj.getMenuName());
            // if count > 0, not save more
            if (count > 0) {
                PAGE = "menu-dong/them";
            } else {
                PAGE = "menu-dong";
                menuDongService.save(obj);
            }
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return new ModelAndView(UtilCon.REDICRECT + UtilHost.LOCALHOST + "/admin/" + PAGE);
    }

    @GetMapping(value = "/" + MENU_DONG + "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        // log info
        log.debug("Go to: /admin/menu-dong/edit/" + id);

        try {
            // set host, bootstrap
            setCommon(model);

            MenuDong obj = menuDongService.findById(id).get();
            model.addAttribute("menuDong", obj);
            model.addAttribute(UtilCon.PAGE, UtilCon.MENU_DONG_EDIT);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilCon.goAdmin();
    }

    @PostMapping(value = "/" + MENU_DONG + "/update")
    public ModelAndView update(@ModelAttribute(MENU_DONG) MenuDong obj) {
        // log info
        log.debug("Go to: /admin/menu-dong/update/" + obj.getMenuDongId());

        try {
            obj = UtilCon.trimObject(obj);
            String menuLink = UtilCon.createLinkFromMenuName(obj.getMenuName());
            obj.setMenuLink(menuLink);

            menuDongService.save(obj);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return new ModelAndView(UtilCon.REDICRECT + UtilHost.LOCALHOST + "/admin/menu-dong");
    }

    @GetMapping(value = "/" + MENU_DONG + "/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        // log info
        log.debug("Go to: /admin/menu-dong/delete/" + id);

        try {
            menuDongService.deleteById(id);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return new ModelAndView(UtilCon.REDICRECT + UtilHost.LOCALHOST + "/admin/" + MENU_DONG);
    }
	
}
