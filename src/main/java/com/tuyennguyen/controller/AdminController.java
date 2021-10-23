package com.tuyennguyen.controller;

import com.tuyennguyen.util.UtilCon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AdminController extends WebController {

    Logger logger = LoggerFactory.getLogger(AdminController.class);
    private static final String mainObject = "admin";

    @GetMapping(value = "/admin")
    public String admin(Model model) {
        System.out.println("he he");
        logger.debug("Go to " + UtilCon.toAdmin());
        setCommon(model);

        return UtilCon.toAdmin(mainObject);
    }

    @RequestMapping("/admin-login")
    public RedirectView localRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/login");
        return redirectView;
    }

}
