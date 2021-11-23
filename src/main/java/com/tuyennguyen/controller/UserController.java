package com.tuyennguyen.controller;

import com.tuyennguyen.entity.Role;
import com.tuyennguyen.entity.User;
import com.tuyennguyen.repository.UserRepository;
import com.tuyennguyen.serivce.UserService;
import com.tuyennguyen.util.EnumRole;
import com.tuyennguyen.util.UtilHost;
import com.tuyennguyen.util.UtilCon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class UserController extends WebController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String MAIN_OBJECT = "user";

    @Autowired
    private UserService mainService;

    @Autowired
    private UserRepository userRepo;

    @GetMapping(value = "/" + MAIN_OBJECT)
    public String getList(Model model) {
        logger.debug("Go to " + UtilCon.toAdmin(MAIN_OBJECT));
        setCommon(model);

        List<User> listUser = mainService.findAll();
        model.addAttribute("listUser", listUser);
        model.addAttribute(UtilCon.PAGE, UtilCon.USER);

        return UtilCon.toAdmin();
    }

    private List<Role> getListRole() {
        Role role;

        List<Role> listRole = new ArrayList<>();
        role = new Role(EnumRole.ADMIN.getRoleId(), EnumRole.ADMIN.getRoleName());
        listRole.add(role);
        role = new Role(EnumRole.USER.getRoleId(), EnumRole.USER.getRoleName());
        listRole.add(role);

        return listRole;
    }

    @GetMapping(value = "/" + MAIN_OBJECT + "/them")
    public String them(Model model) {
        logger.debug("Go to the add screen: " + UtilCon.toAdmin(MAIN_OBJECT));
        setCommon(model);

        List<Role> listRole = getListRole();
        model.addAttribute("listRole", listRole);

        model.addAttribute(UtilCon.OBJ, new User());
        model.addAttribute(UtilCon.PAGE, UtilCon.USER_THEM);
        return UtilCon.toAdmin();
    }

    @PostMapping(value = "/" + MAIN_OBJECT + "/save")
    public ModelAndView save(@ModelAttribute(UtilCon.OBJ) User obj) {
        obj = UtilCon.trimObject(obj);

        String PAGE = "";
        int count = userRepo.countUserByUsernameOrEmail(obj.getUsername(), obj.getEmail());
        System.out.println(count);
        // if count > 0, not save more
        if (count > 0) {
            PAGE = "user/them";
        } else {
            PAGE = "user";
            mainService.save(obj);
        }

        return new ModelAndView("redirect:" + UtilHost.LOCALHOST + "/admin/" + PAGE);
    }

    @GetMapping(value = "/" + MAIN_OBJECT + "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        setCommon(model);

        List<Role> listRole = getListRole();
        model.addAttribute("listRole", listRole);

        Optional<User> obj = mainService.findById(id);
        model.addAttribute(MAIN_OBJECT, obj);
        model.addAttribute(UtilCon.PAGE, UtilCon.USER_EDIT);

        return UtilCon.toAdmin();
    }

    @PostMapping(value = "/" + MAIN_OBJECT + "/update")
    public ModelAndView update(@ModelAttribute(UtilCon.OBJ) User obj) {
        obj = UtilCon.trimObject(obj);

        String PAGE = "";
        mainService.save(obj);

        return new ModelAndView("redirect:" + UtilHost.LOCALHOST + "/admin/user");
    }

    @GetMapping(value = "/" + MAIN_OBJECT + "/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        mainService.deleteById(id);

        return new ModelAndView("redirect:" + UtilHost.LOCALHOST + "/admin/" + MAIN_OBJECT);
    }

}
