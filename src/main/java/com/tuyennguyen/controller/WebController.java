package com.tuyennguyen.controller;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.entity.Setting;
import com.tuyennguyen.serivce.MenuDongService;
import com.tuyennguyen.serivce.SettingService;
import com.tuyennguyen.util.UtilCon;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;

@Data
public class WebController {

    private String title;

    @Autowired
    private SettingService settingService;

    @Autowired
    private MenuDongService menuDongService;

    public void setBootstrapAndJquery(Model model) {
        model.addAttribute("bootstrapCss", UtilCon.localhost + UtilCon.FOR_SL + UtilCon.BOOTSTRAP_CSS);
        model.addAttribute("bootstrapJs", UtilCon.localhost + UtilCon.FOR_SL + UtilCon.BOOTSTRAP_JS);
        model.addAttribute("jquery", UtilCon.localhost + UtilCon.FOR_SL + UtilCon.BOOTSTRAP_JS);
    }

    public void setCommon(Model model, String title) {
        // set host
        model.addAttribute("host", UtilCon.localhost);
        // set title
        model.addAttribute("title", title);
        setBootstrapAndJquery(model);
    }

    public void setListMenuDong(Model model) {
        List<MenuDong> listMenuDong = menuDongService.findAll();
        model.addAttribute("listMenuDong", listMenuDong);
    }

    public void setSetting(Model model) {
        Setting setting = settingService.findById(1).get();
        model.addAttribute("setting", setting);
    }

    public void setListMenuDongCha(Model model, int isParent) {
        List<MenuDong> listMenuDongCha = menuDongService.findAllByIsParent(isParent);
        model.addAttribute("listMenuDongCha", listMenuDongCha);
    }

}
