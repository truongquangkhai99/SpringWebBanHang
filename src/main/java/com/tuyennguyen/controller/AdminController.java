package com.tuyennguyen.controller;

import com.tuyennguyen.serivce.UserService;
import com.tuyennguyen.util.UtilCon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController extends WebController {

    Logger logger = LoggerFactory.getLogger(AdminController.class);
    private static final String mainObject = "admin";

    @GetMapping(value = "/")
    public String admin(Model model) {
        logger.debug("Go to " + UtilCon.toAdmin());
        setCommon(model);

        return UtilCon.toAdmin(mainObject);
    }

}
