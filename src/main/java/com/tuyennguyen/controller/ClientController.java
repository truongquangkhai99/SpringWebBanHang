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

import java.util.List;

@Controller
public class ClientController extends WebController {

    Logger logger = LoggerFactory.getLogger(ClientController.class);
    private static final String mainObject = "client";

    @Autowired
    private MenuDongService mainService;

    @GetMapping(value = "/")
    public String goHome(Model model) {
        logger.debug("Go to " + UtilCon.toClient("home"));
        setCommon(model);

        List<MenuDong> listMenuDong = mainService.findAll();
        model.addAttribute("listMenuDong", listMenuDong);

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
