package com.sedrakpc.example.dao.impl;

import com.sedrakpc.example.dao.AbstractDao;
import com.sedrakpc.example.dao.DataStoreDao;
import com.sedrakpc.example.domain.DataStore;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by: Sedrak Dalaloyan
 * Date: 4/5/16
 * Time: 5:25 PM
 */
@Repository
@Transactional
public class DataStoreDaoImpl extends AbstractDao implements DataStoreDao {

    @Override
    public void save(DataStore dataStore) {
        persist(dataStore);
    }

    @Override
    public DataStore findById(String id) {
        Criteria criteria = getSession().createCriteria(DataStore.class);
        criteria.add(Restrictions.eq("id", id));
        return (DataStore) criteria.uniqueResult();
    }
}
