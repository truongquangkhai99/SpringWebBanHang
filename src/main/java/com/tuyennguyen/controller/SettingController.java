package com.tuyennguyen.controller;

import com.tuyennguyen.entity.Setting;
import com.tuyennguyen.serivce.SettingService;
import com.tuyennguyen.util.FileUploadUtil;
import com.tuyennguyen.util.UtilCon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class SettingController extends WebController {

    Logger log = LoggerFactory.getLogger(SettingController.class);

    private static final String SETTING = "setting";

    @Autowired
    private SettingService settingService;

    @GetMapping(value = "/" + SETTING + "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        // log info
        log.debug("Go to: /admin/setting/edit/" + id);

        try {
            // set title of html page
            setTitle("setting");
            // set host, bootstrap
            setCommon(model, getTitle());

            Setting obj = settingService.findById(id).get();
            model.addAttribute(SETTING, obj);
            model.addAttribute(UtilCon.PAGE, UtilCon.SETTING_EDIT);

            setListMenuDong(model);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilCon.goAdmin();
    }

    @PostMapping(value = "/" + SETTING + "/update")
    public ModelAndView update(@ModelAttribute(SETTING) Setting obj,
                               @RequestParam("imageFile") MultipartFile imageFile) {
        // log info
        log.debug("Go to: /admin/product/update/" + obj.getSettingId());

        try {
            String imageName = imageFile.getOriginalFilename();
            if (!UtilCon.EMPTY.equals(imageName)) {
                FileUploadUtil.saveFile(UtilCon.PATH_TO_STATIC + "/" + UtilCon.imageFolder, imageName, imageFile);
                obj.setImageName(imageName);
            }

            settingService.save(obj);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }
        return new ModelAndView(UtilCon.REDICRECT + UtilCon.localhost + "/admin/setting/edit/" + obj.getSettingId());
    }

}
