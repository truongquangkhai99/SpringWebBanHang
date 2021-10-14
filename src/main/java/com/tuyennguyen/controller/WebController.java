package com.tuyennguyen.controller;

import com.tuyennguyen.util.HostNameConfig;
import com.tuyennguyen.util.UtilCon;
import org.slf4j.Logger;
import org.springframework.ui.Model;

public class WebController {

    public void setHost(Model model) {
        model.addAttribute("host", HostNameConfig.LOCALHOST);
    }

    public void setBootstrapAndJquery(Model model) {
        model.addAttribute("bootstrapCss", HostNameConfig.LOCALHOST + UtilCon.FOR_SL + UtilCon.BOOTSTRAP_CSS);
        model.addAttribute("bootstrapJs", HostNameConfig.LOCALHOST + UtilCon.FOR_SL + UtilCon.BOOTSTRAP_JS);
        model.addAttribute("jquery", HostNameConfig.LOCALHOST + UtilCon.FOR_SL + UtilCon.BOOTSTRAP_JS);
    }

    public void setCommon(Model model) {
        setHost(model);
        setBootstrapAndJquery(model);
    }


	
}
