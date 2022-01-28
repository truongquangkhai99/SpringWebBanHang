package com.tuyennguyen.controller;

import com.tuyennguyen.entity.Article;
import com.tuyennguyen.repository.ArticleRepository;
import com.tuyennguyen.serivce.ArticleService;
import com.tuyennguyen.util.UtilCon;
import com.tuyennguyen.util.UtilDb;
import com.tuyennguyen.util.UtilPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ArticleController extends WebController {

    Logger log = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article")
    public String showList(Model model) {
        // log info
        log.debug("Go to: /admin/article");

        try {
            // set title of html page
            setTitle("Article");
            // backup db
            UtilDb.backUpDb();
            setCommon(model, getTitle());

            //set list
            List<Article> listArticle = articleService.findAll();
            model.addAttribute("listArticle", listArticle);
            //set page
            model.addAttribute(UtilCon.PAGE, UtilCon.ARTICLE);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilPath.toAdmin();
    }

    @GetMapping("/article/them")
    public String them(Model model) {
        // log info
        log.debug("Go to: /admin/article/them");

        try {
            // set title of html page
            setTitle("Thêm Article");
            // set host, bootstrap
            setCommon(model, getTitle());

            model.addAttribute(UtilCon.PAGE, UtilCon.ARTICLE_THEM);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilPath.toAdmin();
    }

    @PostMapping("/article/save")
    public ModelAndView save(@ModelAttribute(UtilCon.OBJ) Article obj) {
        // log info
        log.debug("Go to: /admin/article/save/" + obj.getUserId());

        String PAGE = "";

        try {

            PAGE = "article";
            articleService.save(obj);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return new ModelAndView(UtilCon.REDICRECT + UtilCon.localhost + "/admin/" + PAGE);
    }

    @GetMapping("/article/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        // log info
        log.debug("Go to: /admin/article/edit/" + id);

        try {
            // set title of html page
            setTitle("Sửa Article");
            // set host, bootstrap
            setCommon(model, getTitle());

            Article obj = articleService.findById(id).get();
            model.addAttribute("article", obj);
            model.addAttribute(UtilCon.PAGE, UtilCon.ARTICLE_EDIT);

        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return UtilPath.toAdmin();
    }

    @PostMapping("/article/update")
    public ModelAndView update(@ModelAttribute(UtilCon.OBJ) Article obj) {
        // log info
        log.debug("Go to: /admin/article/update/" + obj.getUserId());

        String PAGE = "";

        try {

            PAGE = "user";
            articleService.save(obj);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return new ModelAndView(UtilCon.REDICRECT + UtilCon.localhost + "/admin/" + PAGE);
    }

    @GetMapping("/article/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        // log info
        log.debug("Go to: /admin/article/delelte/" + id);

        try {
            articleService.deleteById(id);
        } catch (Exception e) {
            UtilCon.logData(log, e);
        }

        return new ModelAndView(UtilCon.REDICRECT + UtilCon.localhost + "/admin/article");
    }

}
