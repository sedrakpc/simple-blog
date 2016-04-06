package com.sedrakpc.example.dao;

import com.sedrakpc.example.domain.DataStore;

/**
 * Created by: Sedrak Dalaloyan
 * Date: 4/5/16
 * Time: 5:22 PM
 */
public interface DataStoreDao {

    void save(DataStore article);
    DataStore findById(String id);
}
