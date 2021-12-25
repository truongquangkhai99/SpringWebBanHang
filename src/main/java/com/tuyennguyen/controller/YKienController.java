package com.tuyennguyen.controller;

import com.tuyennguyen.entity.YKien;
import com.tuyennguyen.serivce.YKienService;
import com.tuyennguyen.util.UtilCon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class YKienController extends WebController {

    Logger log = LoggerFactory.getLogger(YKienController.class);
    private static final String Y_KIEN = "y-kien";

    @Autowired
    private YKienService yKienService;

    @PostMapping(value = "/" + Y_KIEN + "/save")
    public ModelAndView save(@ModelAttribute(UtilCon.OBJ) YKien obj) {
        // log info
        log.debug("Go to: /admin/y-kien/save/");
        String PAGE = "";

        try {
            PAGE = "y-kien/them";
            yKienService.save(obj);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return new ModelAndView(UtilCon.toClient());
    }

}
