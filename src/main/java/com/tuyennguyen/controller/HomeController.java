package com.tuyennguyen.controller;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.serivce.MenuDongService;
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
public class HomeController extends WebController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);
    private static final String mainObject = "home";

    @Autowired
    private MenuDongService mainService;

    @GetMapping(value = "/")
    public String goHome(Model model) {
        logger.debug("Go to " + UtilCon.toClient(mainObject));
        setCommon(model);

        List<MenuDong> listMenuDong = mainService.findAll();
        model.addAttribute("listMenuDong", listMenuDong);

        return UtilCon.toClient(mainObject);
    }
	
}
