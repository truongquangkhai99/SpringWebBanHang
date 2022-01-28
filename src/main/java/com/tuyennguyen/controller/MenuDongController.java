package com.tuyennguyen.controller;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.repository.MenuDongRepository;
import com.tuyennguyen.serivce.MenuDongService;
import com.tuyennguyen.util.UtilCon;
import com.tuyennguyen.util.UtilDb;
import com.tuyennguyen.util.UtilPath;
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

    @Autowired
    private MenuDongService menuDongService;

    @Autowired
    private MenuDongRepository menuDongRepo;

    @Override
    public void setListMenuDong(Model model) {
        super.setListMenuDong(model);
    }

    @GetMapping("/menu-dong")
    public String showList(Model model) {
        // log info
        log.debug("Go to: /admin/menu-dong");

        try {
            String TITLE = "Menu Động";
            // backup db
            UtilDb.backUpDb();
            // set host, bootstrap
            setCommon(model, TITLE);
            //set list
            setListMenuDong(model);

            //set page
            model.addAttribute(UtilCon.PAGE, UtilCon.MENU_DONG);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilPath.toAdmin();
    }

    @GetMapping("/menu-dong/them")
    public String them(Model model) {
        // log info
        log.debug("Go to: /admin/menu-dong/them");

        try {
            String TITLE = "Thêm Menu Động";
            // set host, bootstrap
            setCommon(model, TITLE);

            model.addAttribute(UtilCon.PAGE, UtilCon.MENU_DONG_THEM);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilPath.toAdmin();
    }

    @PostMapping("/menu-dong/save")
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

        return new ModelAndView(UtilCon.REDICRECT + UtilCon.localhost + "/admin/" + PAGE);
    }

    @GetMapping("/menu-dong/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        // log info
        log.debug("Go to: /admin/menu-dong/edit/" + id);

        try {
            // set title of html page
            setTitle("Sửa Menu Động");
            // set host, bootstrap
            setCommon(model, getTitle());

            MenuDong obj = menuDongService.findById(id).get();
            model.addAttribute("menuDong", obj);
            model.addAttribute(UtilCon.PAGE, UtilCon.MENU_DONG_EDIT);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilPath.toAdmin();
    }

    @PostMapping("/menu-dong/update")
    public ModelAndView update(@ModelAttribute("menu-dong") MenuDong obj) {
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

        return new ModelAndView(UtilCon.REDICRECT + UtilCon.localhost + "/admin/menu-dong");
    }

    @GetMapping("/menu-dong/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        // log info
        log.debug("Go to: /admin/menu-dong/delete/" + id);

        try {
            menuDongService.deleteById(id);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return new ModelAndView(UtilCon.REDICRECT + UtilCon.localhost + "/admin/menu-dong");
    }

}
