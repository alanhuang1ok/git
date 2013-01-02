/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.base;

import com.zqgame.common.page.Page;
import com.zqgame.common.page.PageRequest;
import com.zqgame.util.BeanUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.RowBounds;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 *
 * @author alan
 */
public class Basebatis3Dao<T extends Object, PK extends Serializable> extends SqlSessionDaoSupport implements IBaseDao<T, PK> {
//implements IBaseDao<E,PK>

    private final static String SEPARATOR = "_";
    private final SqlMapperXmlHelper xmlMapper = new SqlMapperXmlHelper();

    public String getIbatisSqlMapNamespace() {
        throw new RuntimeException("getIbatisSqlMapNamespace() not yet implement");
    }

    public int add(T entity) throws Exception {
        return add(xmlMapper.getInsertStatement(), entity);
    }

    public int add(String classMethod, T entity) throws Exception {
        int flag;
        try {

            flag = this.getSqlSession().insert(classMethod, entity);
        } catch (Exception e) {
            flag = -1;
            throw e;
        }
        return flag;
    }

    public boolean edit(T entity) throws Exception {
        return edit(xmlMapper.getUpdateStatement(), entity);
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

    public T get(PK id) throws Exception {
        return get(xmlMapper.getFindByPrimaryKeyStatement(), id);
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
        return getAll(xmlMapper.getAllListStatement());
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

    public boolean remove(T entity) throws Exception {
        return remove(xmlMapper.getDeleteStatement(), entity);
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

    protected Page pageQuery(String statementName, PageRequest pageRequest) {

        Number totalCount = (Number) this.getSqlSession().selectOne(xmlMapper.getCountQuery(), pageRequest.getFilters());
        Page page = new Page(pageRequest, totalCount.intValue());

        //其它分页参数,用于不喜欢或是因为兼容性而不使用方言(Dialect)的分页用户使用. 与getSqlMapClientTemplate().queryForList(statementName, parameterObject)配合使用
        Map filters = new HashMap();
        filters.put("offset", page.getFirstResult());
        filters.put("pageSize", page.getPageSize());
        filters.put("lastRows", page.getFirstResult() + page.getPageSize());
        filters.put("sortColumns", pageRequest.getSortColumns());

        //混合两个filters为一个filters,MapAndObject.get()方法将在两个对象取值,Map如果取值为null,则再在Bean中取值
        if (pageRequest.getFilters() instanceof Map) {
            filters.putAll((Map) pageRequest.getFilters());
        } else {
            Map parameterObject = BeanUtils.describe(pageRequest.getFilters());
            filters.putAll(parameterObject);
        }
        List<Object> list = this.getSqlSession().selectList(statementName, filters, new RowBounds(page.getFirstResult(), page.getPageSize()));
        //	List list = getSqlSessionTemplate().selectList(statementName, filters,page.getFirstResult(),page.getPageSize());
        page.setResult(list);
        return page;
    }

    /**
     * 负责提供对应的sql节点名称
     */
    class SqlMapperXmlHelper {

        //sqlMaping 语句
        public String getFindByPrimaryKeyStatement() {
            return new StringBuffer(getIbatisSqlMapNamespace()).append(SEPARATOR).append("getById").toString();
        }

        public String getAllListStatement() {
            return new StringBuffer(getIbatisSqlMapNamespace()).append(SEPARATOR).append("getAllList").toString();
        }

        public String getInsertStatement() {
            return new StringBuffer(getIbatisSqlMapNamespace()).append(SEPARATOR).append("insert").toString();
        }

        public String getUpdateStatement() {
            return new StringBuffer(getIbatisSqlMapNamespace()).append(SEPARATOR).append("update").toString();
        }

        public String getDeleteStatement() {
            return new StringBuffer(getIbatisSqlMapNamespace()).append(SEPARATOR).append("delete").toString();
        }

        public String getCountStatementForPaging(String statementName) {
             return new StringBuffer(statementName).append(SEPARATOR).append("count").toString();
        }

        public String getCountQuery() {
            return new StringBuffer(getIbatisSqlMapNamespace()).append(SEPARATOR).append("count").toString();
        }
    }
}
