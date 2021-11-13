package com.tuyennguyen.controller;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.entity.Product;
import com.tuyennguyen.serivce.MenuDongService;
import com.tuyennguyen.serivce.ProductService;
import com.tuyennguyen.util.FileUploadUtil;
import com.tuyennguyen.util.UtilHost;
import com.tuyennguyen.util.UtilCon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class ProductController extends WebController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    private static final String MAIN_OBJECT = "product";

    @Autowired
    private ProductService mainService;

    @Autowired
    private MenuDongService menuDongService;

    @GetMapping(value = "/" + MAIN_OBJECT)
    public String getList(Model model) {
        logger.debug("Go to " + UtilCon.toAdmin(MAIN_OBJECT));
        setCommon(model);

        List<Product> listProduct = mainService.findAll();
        model.addAttribute("listProduct", listProduct);
        model.addAttribute(UtilCon.PAGE, UtilCon.PRODUCT);

        return UtilCon.toAdmin();
    }

    @GetMapping(value = "/" + MAIN_OBJECT + "/them")
    public String them(Model model) {
        logger.debug("Go to the add screen: " + UtilCon.toAdmin(MAIN_OBJECT));
        setCommon(model);

        model.addAttribute(UtilCon.OBJ, new Product());
        model.addAttribute(UtilCon.PAGE, UtilCon.PRODUCT_THEM);

        setListMenuDong(model);

        return UtilCon.toAdmin();
    }

    @PostMapping(value = "/" + MAIN_OBJECT + "/save")
    public ModelAndView save(@ModelAttribute(UtilCon.OBJ) Product product, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        String imageName = imageFile.getOriginalFilename();

        product.setImageName(imageName);
        mainService.save(product);

        FileUploadUtil.saveFile(UtilCon.PATH_TO_STATIC + "/" + UtilCon.IMAGE_FOLDER, imageName, imageFile);

        return new ModelAndView("redirect:" + UtilHost.LOCALHOST + "/admin/product");
    }

    @GetMapping(value = "/" + MAIN_OBJECT + "/edit/{id}")
    public String findById(@PathVariable int id, Model model) {
        setCommon(model);
        setListMenuDongCha(model, UtilCon.PARENT);

        Product obj = mainService.findById(id).get();
        model.addAttribute(MAIN_OBJECT, obj);
        model.addAttribute(UtilCon.PAGE, UtilCon.PRODUCT_EDIT);

        setListMenuDong(model);

        return UtilCon.toAdmin();
    }

    @PostMapping(value = "/" + MAIN_OBJECT + "/update")
    public ModelAndView update(@ModelAttribute(MAIN_OBJECT) Product obj, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        String imageName = imageFile.getOriginalFilename();
        if (!UtilCon.EMPTY.equals(imageName)) {
            obj.setImageName(imageName);
        }

        mainService.save(obj);

        // if choose another image, the image is not empty and upload to server
        if (!UtilCon.EMPTY.equals(imageName)) {
            FileUploadUtil.saveFile(UtilCon.PATH_TO_STATIC + "/" + UtilCon.IMAGE_FOLDER, imageName, imageFile);
        }

        return new ModelAndView("redirect:" + UtilHost.LOCALHOST + "/admin/product");
    }

    @GetMapping(value = "/" + MAIN_OBJECT + "/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        mainService.deleteById(id);

        return new ModelAndView("redirect:" + UtilHost.LOCALHOST + "/admin/" + MAIN_OBJECT);
    }

    public void setListMenuDong(Model model) {
        List<MenuDong> listMenuDong = menuDongService.findAll();
        model.addAttribute("listMenuDong", listMenuDong);
    }
	
}
