package com.sedrakpc.example.dao;

import com.sedrakpc.example.domain.Article;

import java.util.List;

/**
 * Created by: Sedrak Dalaloyan
 * Date: 4/5/16
 * Time: 5:22 PM
 */
public interface ArticleDao {

    void save(Article article);
    List loadAll();
    void update(Article article);
    void delete(Article article);
    Article findById(Long articleId);
}
