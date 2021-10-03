package com.tuyennguyen.controller;

import com.tuyennguyen.util.HostNameEnum;
import com.tuyennguyen.util.UtilEnum;
import org.springframework.ui.Model;

public class WebController {

    public void setModelBootstrapCss(Model model) {
        model.addAttribute("bootstrapCss",
                HostNameEnum.LOCALHOST.getValue() +
                        UtilEnum.FORWARD_SLASH.getValue() +
                        HostNameEnum.BOOTSTRAP.getValue());
    }
	
}
