package com.sedrakpc.example.controller;

import com.sedrakpc.example.dao.ArticleDao;
import com.sedrakpc.example.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by: Sedrak Dalaloyan
 * Date: 4/5/16
 * Time: 4:44 PM
 */
@Controller
public class PageController {


    @Value("${app.version}")
    private String appVersion;

    @Autowired
    private ArticleDao articleDao;

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String redirect() {
        return "redirect:/home";
    }

    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        model.addObject("appVersion", appVersion);
        model.setViewName("home");
        Article article = new Article();
        article.setTitle("asdf");
        article.setContent("<div></div>");
        articleDao.save(article);
        return model;
    }

    @RequestMapping(value = "/401", method= RequestMethod.GET)
    public void error401(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "");
    }

    @RequestMapping(value = "/404", method= RequestMethod.GET)
    public void error404(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "");
    }

    @RequestMapping(value = "/500", method= RequestMethod.GET)
    public void error500(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "");
    }
}
