package com.tuyennguyen.controller;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.serivce.MenuDongService;
import com.tuyennguyen.serivce.ProductService;
import com.tuyennguyen.util.HostNameConfig;
import com.tuyennguyen.util.UtilCon;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;

public class WebController {

    @Autowired
    private MenuDongService menuDongService;

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

    public void setListMenuDong(Model model) {
        List<MenuDong> listMenuDong = menuDongService.findAll();
        model.addAttribute("listMenuDong", listMenuDong);
    }

    public void setListMenuDongCha(Model model, int isParent) {
        List<MenuDong> listMenuDongCha = menuDongService.findAllByIsParent(isParent);
        model.addAttribute("listMenuDongCha", listMenuDongCha);
    }


	
}
