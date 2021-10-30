package com.tuyennguyen.controller;

import com.tuyennguyen.entity.Product;
import com.tuyennguyen.entity.User;
import com.tuyennguyen.serivce.ProductService;
import com.tuyennguyen.serivce.UserService;
import com.tuyennguyen.util.HostName;
import com.tuyennguyen.util.UtilCon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class UserController extends WebController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String mainObject = "user";

    @Autowired
    private UserService mainService;

    @GetMapping(value = "/" + mainObject)
    public String getList(Model model) {
        logger.debug("Go to " + UtilCon.toAdmin(mainObject));
        setCommon(model);

        List<User> listUser = mainService.findAll();
        model.addAttribute("list" + UtilCon.upperFirstLetter(mainObject), listUser);

        return UtilCon.toAdmin(mainObject);
    }

    @GetMapping(value = "/" + mainObject + "/them")
    public String them(Model model) {
        logger.debug("Go to the add screen: " + UtilCon.toAdmin(mainObject));
        setCommon(model);

        model.addAttribute(UtilCon.OBJ, new User());
        return UtilCon.toAdmin(mainObject, mainObject + "-them");
    }

    @PostMapping(value = "/" + mainObject + "/save")
    public ModelAndView save(@ModelAttribute(UtilCon.OBJ) User obj) {
        mainService.save(obj);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(UtilCon.toAdmin(mainObject));

        return new ModelAndView("redirect:" + HostName.LOCALHOST + "/admin/user");
    }

    @GetMapping(value = "/" + mainObject + "/edit/{id}")
    public String findById(@PathVariable int id, Model model) {
        setCommon(model);

        Optional<User> obj = mainService.findById(id);
        model.addAttribute(mainObject, obj);

        return UtilCon.toAdmin(mainObject, mainObject + "-edit");
    }

    @PostMapping(value = "/" + mainObject + "/update")
    public ModelAndView update(@ModelAttribute(UtilCon.OBJ) User obj) {
        mainService.save(obj);

        return new ModelAndView("redirect:" + HostName.LOCALHOST + "/admin/user");
    }

    @GetMapping(value = "/" + mainObject + "/delete/{id}")
    public RedirectView delete(@PathVariable int id) {
        Optional<User> obj = mainService.findById(id);

        mainService.deleteById(id);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(UtilCon.toAdmin(mainObject));

        return redirectView;
    }

}
