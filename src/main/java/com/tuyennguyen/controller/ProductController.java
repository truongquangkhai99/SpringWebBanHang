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

    Logger log = LoggerFactory.getLogger(ProductController.class);

    private static final String PRODUCT = "product";

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private MenuDongService menuDongService;

    @GetMapping(value = "/" + PRODUCT)
    public String showList(Model model) {
        // log info
        log.debug("Go to " + UtilCon.toAdmin(PRODUCT));

        try {
            // backup db
            UtilCon.backUpDb();
            // set host, bootstrap
            setCommon(model);

            //set list
            setListProduct(model, UtilCon.VISIBLE_ITEM);
            //set page
            model.addAttribute(UtilCon.PAGE, UtilCon.PRODUCT);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilCon.goAdmin();
    }

    @GetMapping(value = "/" + PRODUCT + "/them")
    public String them(Model model) {
        // log info
        log.debug("Go to the add screen: " + UtilCon.toAdmin(PRODUCT));

        try {
            // set host, bootstrap
            setCommon(model);

            model.addAttribute(UtilCon.OBJ, new Product());
            model.addAttribute(UtilCon.PAGE, UtilCon.PRODUCT_THEM);

            setListMenuDong(model);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilCon.goAdmin();
    }

    @PostMapping(value = "/" + PRODUCT + "/save")
    public ModelAndView save(@ModelAttribute(UtilCon.OBJ) Product obj, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        String PAGE = "";

        try {
            obj = UtilCon.trimObject(obj);
            obj = setSaleButton(obj);

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
                productService.save(obj);
            }
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return new ModelAndView(UtilCon.REDICRECT + UtilHost.LOCALHOST + "/admin/" + PAGE);
    }

    @GetMapping(value = "/" + PRODUCT + "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        try {
            // set host, bootstrap
            setCommon(model);
            setListMenuDongCha(model, UtilCon.PARENT);

            Product obj = productService.findById(id).get();
            model.addAttribute(PRODUCT, obj);
            model.addAttribute(UtilCon.PAGE, UtilCon.PRODUCT_EDIT);

            setListMenuDong(model);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilCon.goAdmin();
    }

    @PostMapping(value = "/" + PRODUCT + "/update")
    public ModelAndView update(@ModelAttribute(PRODUCT) Product obj, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        try {
            obj = UtilCon.trimObject(obj);
            obj = setSaleButton(obj);

            String imageName = imageFile.getOriginalFilename();
            if (!UtilCon.EMPTY.equals(imageName)) {
                FileUploadUtil.saveFile(UtilCon.PATH_TO_STATIC + "/" + UtilCon.IMAGE_FOLDER, imageName, imageFile);
                obj.setImageName(imageName);
            }

            productService.save(obj);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }
        return new ModelAndView(UtilCon.REDICRECT + UtilHost.LOCALHOST + "/admin/product");
    }

    @GetMapping(value = "/" + PRODUCT + "/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        try {
            productService.deleteById(id);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return new ModelAndView(UtilCon.REDICRECT + UtilHost.LOCALHOST + "/admin/" + PRODUCT);
    }

    @GetMapping(value = "/" + PRODUCT + "/filter/{filterItem}")
    public String filter(@PathVariable int filterItem, Model model) {
        try {
            // set host, bootstrap
            setCommon(model);

            setListProduct(model, filterItem);
            model.addAttribute(UtilCon.PAGE, UtilCon.PRODUCT);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilCon.goAdmin();
    }

    public void setListMenuDong(Model model) {
        List<MenuDong> listMenuDong = menuDongService.findAll();
        model.addAttribute("listMenuDong", listMenuDong);
    }

    private void setListProduct(Model model, final int FILTER_ITEM) {
        List<ProductMap> listProductMap = null;

        // get listProductMap
        if (FILTER_ITEM == UtilCon.ALL_ITEM) {
            // all item
            listProductMap = productService.getListProductMap(UtilCon.ALL_ITEM);
        } else if (FILTER_ITEM == UtilCon.FAVOURITE_ITEM) {
            // favourite item
            listProductMap = productService.getListProductMap(UtilCon.FAVOURITE_ITEM);
        } else if (FILTER_ITEM == UtilCon.INVISIBLE_ITEM) {
            // invisible item
            listProductMap = productService.getListProductMap(UtilCon.INVISIBLE_ITEM);
        } else if (FILTER_ITEM == UtilCon.VISIBLE_ITEM) {
            // invisible item
            listProductMap = productService.getListProductMap(UtilCon.VISIBLE_ITEM);
        }

        model.addAttribute("listProduct", listProductMap);
        model.addAttribute("FILTER_ITEM", FILTER_ITEM);
    }

    private Product setSaleButton(Product obj) {
        // salePrice
        String salePercent = obj.getSalePercent();

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

        obj.setSalePercent(salePercent);
        obj.setSalePrice(UtilCon.formatMoney(salePrice));
        obj.setGiaConLai(UtilCon.formatMoney(giaConLai));
        return obj;
    }
	
}
