package com.tuyennguyen.controller;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.entity.Product;
import com.tuyennguyen.model.mapping.ProductMap;
import com.tuyennguyen.repository.ProductRepository;
import com.tuyennguyen.serivce.MenuDongService;
import com.tuyennguyen.serivce.ProductService;
import com.tuyennguyen.util.FileUploadUtil;
import com.tuyennguyen.util.UtilCon;
import com.tuyennguyen.util.UtilDb;
import com.tuyennguyen.util.UtilPath;
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

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private MenuDongService menuDongService;

    @GetMapping("product")
    public String showList(Model model) {
        // log info
        log.debug("Go to: /admin/product");

        try {
            // set title of html page
            setTitle("Product");
            // backup db
            UtilDb.backUpDb();
            // set host, bootstrap
            setCommon(model, getTitle());

            //set list
            setListProduct(model, UtilCon.VISIBLE_ITEM);
            //set page
            model.addAttribute(UtilCon.PAGE, UtilCon.PRODUCT);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilPath.toAdmin();
    }

    @GetMapping("/product/them")
    public String them(Model model) {
        // log info
        log.debug("Go to: /admin/product/them");

        try {
            // set title of html page
            setTitle("Thêm Product");
            // set host, bootstrap
            setCommon(model, getTitle());

            model.addAttribute(UtilCon.OBJ, new Product());
            model.addAttribute(UtilCon.PAGE, UtilCon.PRODUCT_THEM);

            setListMenuDong(model);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilPath.toAdmin();
    }

    @PostMapping("/product/save")
    public ModelAndView save(@ModelAttribute(UtilCon.OBJ) Product obj,
                             @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        // log info
        log.debug("Go to: /admin/product/save" + obj.getProductId());

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
                    FileUploadUtil.saveFile(UtilCon.PATH_TO_STATIC + "/" + UtilCon.imageFolder, imageName, imageFile);
                    obj.setImageName(imageName);
                }
                productService.save(obj);
            }
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return new ModelAndView(UtilCon.REDICRECT + UtilCon.localhost + "/admin/" + PAGE);
    }

    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        // log info
        log.debug("Go to: /admin/product/edit/" + id);

        try {
            // set title of html page
            setTitle("Sửa Product");
            // set host, bootstrap
            setCommon(model, getTitle());
            setListMenuDongCha(model, UtilCon.PARENT);

            Product obj = productService.findById(id).get();
            model.addAttribute("product", obj);
            model.addAttribute(UtilCon.PAGE, UtilCon.PRODUCT_EDIT);

            setListMenuDong(model);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilPath.toAdmin();
    }

    @PostMapping("/product/update")
    public ModelAndView update(@ModelAttribute("product") Product obj,
                               @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        // log info
        log.debug("Go to: /admin/product/update/" + obj.getProductId());

        try {
            obj = UtilCon.trimObject(obj);
            obj = setSaleButton(obj);

            String imageName = imageFile.getOriginalFilename();
            if (!UtilCon.EMPTY.equals(imageName)) {
                FileUploadUtil.saveFile(UtilCon.PATH_TO_STATIC + "/" + UtilCon.imageFolder, imageName, imageFile);
                obj.setImageName(imageName);
            }

            productService.save(obj);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }
        return new ModelAndView(UtilCon.REDICRECT + UtilCon.localhost + "/admin/product");
    }

    @GetMapping("/product/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        // log info
        log.debug("Go to: /admin/product/delete/" + id);

        try {
            productService.deleteById(id);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return new ModelAndView(UtilCon.REDICRECT + UtilCon.localhost + "/admin/product");
    }

    @GetMapping("/product/filter/{filterItem}")
    public String filter(@PathVariable int filterItem, Model model) {
        // log info
        log.debug("Go to: /admin/product/filter/" + filterItem);

        try {
            // set title of html page
            setTitle("Product");
            // set host, bootstrap
            setCommon(model, getTitle());

            setListProduct(model, filterItem);
            model.addAttribute(UtilCon.PAGE, UtilCon.PRODUCT);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilPath.toAdmin();
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
        // get price
        String price = obj.getPrice().replaceAll("[.]", "");
        // get sale percent
        String salePercent = obj.getSalePercent();
        // get sale price
        String salePrice = obj.getSalePrice();
        String giaConLai = price;

        // format price, tính salePrice
        if (!"".equals(price)) {
            if ("".equals(salePercent)) {
                // if salePercent = 0%
                salePrice = price;
            } else {
                //if salePercent > 0%
                salePrice = Long.parseLong(price) * Integer.parseInt(salePercent) / 100 + "";
                giaConLai = String.valueOf(Long.parseLong(price) - Long.parseLong(salePrice));

                // set sale price
                obj.setSalePrice(UtilCon.formatMoney(salePrice));
                obj.setGiaConLai(UtilCon.formatMoney(giaConLai));
            }
        } else {
            // do nothing
        }

        // format money price
        obj.setPrice(UtilCon.formatMoney(price));

        return obj;
    }

}
