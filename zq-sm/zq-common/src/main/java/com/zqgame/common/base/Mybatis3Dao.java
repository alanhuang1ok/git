/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.common.base;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author alan
 */
public class Mybatis3Dao<E,PK extends Serializable> implements IBaseDao<E,PK> {

    public Object getById(PK id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteById(PK id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void save(E entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(E entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void saveOrUpdate(E entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<E> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
