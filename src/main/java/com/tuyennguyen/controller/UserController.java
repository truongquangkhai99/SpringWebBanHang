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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class UserController extends WebController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String USER = "user";

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepo;

    @GetMapping(value = "/" + USER)
    public String showList(Model model) {
        logger.debug("Go to " + UtilCon.toAdmin(USER));
        setCommon(model);

        //set list
        List<User> listUser = userService.findAll();
        model.addAttribute("listUser", listUser);
        //set page
        model.addAttribute(UtilCon.PAGE, UtilCon.USER);

        return UtilCon.goAdmin();
    }

    @GetMapping(value = "/" + USER + "/them")
    public String them(Model model) {
        logger.debug("Go to the add screen: " + UtilCon.toAdmin(USER));
        // set host, bootstrap
        setCommon(model);

        List<Role> listRole = getListRole();
        model.addAttribute("listRole", listRole);

        model.addAttribute(UtilCon.OBJ, new User());
        model.addAttribute(UtilCon.PAGE, UtilCon.USER_THEM);
        return UtilCon.goAdmin();
    }

    @PostMapping(value = "/" + USER + "/save")
    public ModelAndView save(@ModelAttribute(UtilCon.OBJ) User obj) {

        obj = UtilCon.trimObject(obj);

        String PAGE = "";
        int count = userRepo.countUserByUsernameOrEmail(obj.getUsername(), obj.getEmail());
        // if count > 0, not save more
        if (count > 0) {
            PAGE = "user/them";
        } else {
            PAGE = "user";
            userService.save(obj);
        }

        return new ModelAndView(UtilCon.REDICRECT + UtilHost.LOCALHOST + "/admin/" + PAGE);
    }

    @GetMapping(value = "/" + USER + "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        // set host, bootstrap
        setCommon(model);

        List<Role> listRole = getListRole();
        model.addAttribute("listRole", listRole);

        Optional<User> obj = userService.findById(id);
        model.addAttribute(USER, obj);
        model.addAttribute(UtilCon.PAGE, UtilCon.USER_EDIT);

        return UtilCon.goAdmin();
    }

    @PostMapping(value = "/" + USER + "/update")
    public ModelAndView update(@ModelAttribute(UtilCon.OBJ) User obj) {
        obj = UtilCon.trimObject(obj);

        String PAGE = "";
        int count = userRepo.countUserByUsernameOrEmail(obj.getUsername(), obj.getEmail());
        // if count > 0, not save more
        if (count > 1) {
            PAGE = "user/edit/" + obj.getUserId();
        } else {
            PAGE = "user";
            userService.save(obj);
        }

        return new ModelAndView(UtilCon.REDICRECT + UtilHost.LOCALHOST + "/admin/" + PAGE);
    }

    @GetMapping(value = "/" + USER + "/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        userService.deleteById(id);

        return new ModelAndView(UtilCon.REDICRECT + UtilHost.LOCALHOST + "/admin/" + USER);
    }

    private List<Role> getListRole() {
        Role role;

        // set list role
        List<Role> listRole = new ArrayList<>();
        role = new Role(EnumRole.ADMIN.getRoleId(), EnumRole.ADMIN.getRoleName());
        listRole.add(role);
        role = new Role(EnumRole.USER.getRoleId(), EnumRole.USER.getRoleName());
        listRole.add(role);

        return listRole;
    }

}
