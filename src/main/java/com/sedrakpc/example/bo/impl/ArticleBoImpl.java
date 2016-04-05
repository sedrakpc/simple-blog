package com.sedrakpc.example.bo.impl;

import com.sedrakpc.example.bo.ArticleBo;
import com.sedrakpc.example.dao.ArticleDao;
import com.sedrakpc.example.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by: Sedrak Dalaloyan
 * Date: 4/5/16
 * Time: 5:18 PM
 */
public class ArticleBoImpl implements ArticleBo {

    @Autowired
    private ArticleDao articleDao;

    public void save(Article article) {

    }

    public void update(Article article) {

    }

    public void delete(Article article) {

    }

    public Article findById(Long articleId) {
        return null;
    }
}
