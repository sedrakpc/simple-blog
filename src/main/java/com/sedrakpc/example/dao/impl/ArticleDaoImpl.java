package com.sedrakpc.example.dao.impl;

import com.sedrakpc.example.dao.AbstractDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import com.sedrakpc.example.dao.ArticleDao;
import com.sedrakpc.example.domain.Article;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by: Sedrak Dalaloyan
 * Date: 4/5/16
 * Time: 5:25 PM
 */
@Repository
@Transactional
public class ArticleDaoImpl extends AbstractDao implements ArticleDao {

    public void save(Article article) {
        persist(article);
    }

    public void update(Article article) {
        getSession().update(article);
    }

    public void delete(Article article) {
        Query query = getSession().createSQLQuery("delete from Article where id = :id");
        query.setLong("id", article.getId());
        query.executeUpdate();
    }

    public Article findById(Long articleId) {
        Criteria criteria = getSession().createCriteria(Article.class);
        criteria.add(Restrictions.eq("id", articleId));
        return (Article) criteria.uniqueResult();
    }
}
