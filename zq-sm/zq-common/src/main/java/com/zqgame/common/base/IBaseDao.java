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
public interface IBaseDao<E, PK extends Serializable> {

    /**
     * 根据ID获取实体
     * @param id
     * @return 
     */
    public Object getById(PK id);

    public void deleteById(PK id);

    /**
     * 插入数据
     */
    public void save(E entity);

    /**
     * 更新数据
     */
    public void update(E entity);

    /**
     * 根据id检查是否插入或是更新数据
     */
    public void saveOrUpdate(E entity);

    public List<E> findAll();
}
