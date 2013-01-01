/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.base;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 *
 * @author alan
 */
public class Basebatis3Dao<T extends Object,PK extends Serializable> extends SqlSessionDaoSupport implements IBaseDao<T,PK> {
//implements IBaseDao<E,PK>

    public String getIbatisSqlMapNamespace() {
        throw new RuntimeException("getIbatisSqlMapNamespace() not yet implement");
    }

    public int add(T entity) throws Exception {
        return add(getInsertStatement(), entity);
    }

    public int add(String classMethod, T entity) throws Exception {
        int flag;
        try {

            flag = this.getSqlSession().insert(classMethod, entity)  ;
        } catch (Exception e) {
            flag = -1;
            throw e;
        }
        return flag;
    }

    public boolean edit(T entity) throws Exception {
        return edit(getUpdateStatement(), entity);
    }

    public boolean edit(String classMethod, T entity) throws Exception {
        boolean flag = false;
        try {
            flag = this.getSqlSession().update(classMethod, entity) > 0 ? true : false;
        } catch (Exception e) {
            flag = false;
            throw e;
        }
        return flag;
    }

    public T get( PK id) throws Exception {
        return get(getFindByPrimaryKeyStatement(), id);
    }

    public T get(String classMethod, PK id) throws Exception {
        T result = null;
        try {
            result = (T) this.getSqlSession().selectOne(classMethod, id);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    public List<T> getAll() throws Exception {
        return getAll(getAllListStatement());
    }

    public List<T> getAll(String classMethod) throws Exception {
        List<T> result = new ArrayList<T>();
        try {
            result = this.getSqlSession().selectList(classMethod);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    public boolean remove(  T entity) throws Exception {
        return remove(getDeleteStatement(),entity);
    }
    
    public boolean remove(String classMethod, T entity) throws Exception {
        boolean flag = false;
        try {
            flag = this.getSqlSession().delete(classMethod, entity) > 0 ? true : false;
        } catch (Exception e) {
            flag = false;
            throw e;
        }
        return flag;
    }

    //sqlMaping 语句
    public String getFindByPrimaryKeyStatement() {
        return getIbatisSqlMapNamespace() + "_getById";
    }

    public String getAllListStatement() {
        return getIbatisSqlMapNamespace() + "_getAllList";
    }

    public String getInsertStatement() {
        return getIbatisSqlMapNamespace() + "_insert";
    }

    public String getUpdateStatement() {
        return getIbatisSqlMapNamespace() + "_update";
    }

    public String getDeleteStatement() {
        return getIbatisSqlMapNamespace() + "_delete";
    }

    public String getCountStatementForPaging(String statementName) {
        return statementName + "_count";
    }
}
