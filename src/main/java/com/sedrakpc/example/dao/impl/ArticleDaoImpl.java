package com.sedrakpc.example.dao.impl;

import com.sedrakpc.example.dao.AbstractDao;
import com.sedrakpc.example.dao.ArticleDao;
import com.sedrakpc.example.domain.Article;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by: Sedrak Dalaloyan
 * Date: 4/5/16
 * Time: 5:25 PM
 */
@Repository
@Transactional
public class ArticleDaoImpl extends AbstractDao implements ArticleDao {

    @Override
    public void save(Article article) {
        persist(article);
    }

    @Override
    public List<Article> loadAll() {
        return getSession().createCriteria(Article.class).addOrder(Order.desc("creationDate")).list();
    }

    @Override
    public void update(Article article) {
        getSession().update(article);
    }

    @Override
    public void delete(Article article) {
        Query query = getSession().createSQLQuery("delete from Article where id = :id");
        query.setLong("id", article.getId());
        query.executeUpdate();
    }

    @Override
    public Article findById(Long articleId) {
        Criteria criteria = getSession().createCriteria(Article.class);
        criteria.add(Restrictions.eq("id", articleId));
        return (Article) criteria.uniqueResult();
    }
}
