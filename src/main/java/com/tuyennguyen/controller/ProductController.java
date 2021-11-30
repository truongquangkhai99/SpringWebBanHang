package com.tuyennguyen.controller;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.entity.Product;
import com.tuyennguyen.model.mapping.ProductMap;
import com.tuyennguyen.repository.ProductRepository;
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

@Controller
@RequestMapping("/admin")
public class ProductController extends WebController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    private static final String MAIN_OBJECT = "product";

    @Autowired
    private ProductService mainService;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private MenuDongService menuDongService;

    @GetMapping(value = "/" + MAIN_OBJECT)
    public String showList(Model model) {
        logger.debug("Go to " + UtilCon.toAdmin(MAIN_OBJECT));
        setCommon(model);

        int allItem = 1;
        setListProduct(model, allItem);
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
    public ModelAndView save(@ModelAttribute(UtilCon.OBJ) Product obj, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        obj = UtilCon.trimObject(obj);
        obj = setSaleButton(obj);

        String PAGE = "";
        int count = productRepo.countProductByProductName(obj.getProductName());
        // if count > 0, not save more
        if (count > 0) {
            PAGE = "product/them";
        } else {
            PAGE = "product";

            String imageName = imageFile.getOriginalFilename();
            if (!UtilCon.EMPTY.equals(imageName)) {
                FileUploadUtil.saveFile(UtilCon.PATH_TO_STATIC + "/" + UtilCon.IMAGE_FOLDER, imageName, imageFile);
                obj.setImageName(imageName);
            }
            mainService.save(obj);
        }


        return new ModelAndView(UtilCon.REDICRECT + UtilHost.LOCALHOST + "/admin/" + PAGE);
    }

    @GetMapping(value = "/" + MAIN_OBJECT + "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
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
        obj = UtilCon.trimObject(obj);
        obj = setSaleButton(obj);

        String imageName = imageFile.getOriginalFilename();
        if (!UtilCon.EMPTY.equals(imageName)) {
            FileUploadUtil.saveFile(UtilCon.PATH_TO_STATIC + "/" + UtilCon.IMAGE_FOLDER, imageName, imageFile);
            obj.setImageName(imageName);
        }

        mainService.save(obj);

        return new ModelAndView(UtilCon.REDICRECT + UtilHost.LOCALHOST + "/admin/product");
    }

    @GetMapping(value = "/" + MAIN_OBJECT + "/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        mainService.deleteById(id);

        return new ModelAndView(UtilCon.REDICRECT + UtilHost.LOCALHOST + "/admin/" + MAIN_OBJECT);
    }

    @GetMapping(value = "/" + MAIN_OBJECT + "/filter/{filter}")
    public String filter(@PathVariable int filter, Model model) {
        setCommon(model);

        setListProduct(model, filter);
        model.addAttribute(UtilCon.PAGE, UtilCon.PRODUCT);

        return UtilCon.toAdmin();
    }

    public void setListMenuDong(Model model) {
        List<MenuDong> listMenuDong = menuDongService.findAll();
        model.addAttribute("listMenuDong", listMenuDong);
    }

    public void setListProduct(Model model, int filter) {
        int allItem = 1;
        int favourite = 2;
        int invisible = 3;

        if (filter == allItem) {
            List<Product> listProduct = mainService.findAll();
            model.addAttribute("listProduct", listProduct);
        } else if (filter == favourite) {
            List<Product> listProduct = productRepo.findProductsByFavourite(UtilCon.FAVOURITE);
            model.addAttribute("listProduct", listProduct);
        } else if (filter == invisible) {
            List<Product> listProduct = productRepo.findProductsByIsVisible(UtilCon.INVISIBLE);
            model.addAttribute("listProduct", listProduct);
        }
        model.addAttribute("filter", filter);
    }

    private Product setSaleButton(Product obj) {
        // salePrice
        String salePercent = obj.getSalePercent();
        if (salePercent.contains("%")) {
            salePercent = salePercent.replaceAll("%", "");
        } else {
            // do nothing
        }

        // price
        String price = obj.getPrice().replaceAll("[.]", "");
        // salePrice
        String salePrice = obj.getSalePrice();
        String giaConLai = price;

        // format price, tính salePrice
        if (!"".equals(price)) {
            if ("".equals(salePercent) || Integer.parseInt(salePercent) == 0) {
                // if salePercent = 0%
                salePrice = price;
            } else {
                //if salePercent > 0%
                salePrice = Long.parseLong(price) * Integer.parseInt(salePercent) / 100 + "";
                giaConLai = String.valueOf(Long.parseLong(price) - Long.parseLong(salePrice));
            }
        } else {
            // do nothing
        }

        // set % for salePercent
        salePercent += "%";

        obj.setSalePercent(salePercent);
        obj.setSalePrice(UtilCon.formatMoney(salePrice));
        obj.setGiaConLai(UtilCon.formatMoney(giaConLai));
        return obj;
    }
	
}
