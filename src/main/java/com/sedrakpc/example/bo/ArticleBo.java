package com.sedrakpc.example.bo;

import com.sedrakpc.example.domain.Article;

/**
 * Created by: Sedrak Dalaloyan
 * Date: 4/5/16
 * Time: 5:20 PM
 */
public interface ArticleBo {

    void save(Article article);
    void update(Article article);
    void delete(Article article);
    Article findById(Long articleId);
}
