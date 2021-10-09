package com.tuyennguyen.controller;

import com.tuyennguyen.util.HostNameConfig;
import com.tuyennguyen.util.UtilCon;
import org.springframework.ui.Model;

public class WebController {

    public void setHost(Model model) {
        model.addAttribute("host", HostNameConfig.LOCALHOST);
    }

    public void setBootstrap(Model model) {
        model.addAttribute("bootstrapCss",
                HostNameConfig.LOCALHOST +
                        UtilCon.FOR_SL +
                        UtilCon.BOOTSTRAP);
    }
	
}
