/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.base;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author alan
 */
public interface IBaseDao<T,PK extends Serializable> {
 
    public int add(String classMethod, T entity) throws Exception;
    
    public boolean edit(String classMethod, T entity) throws Exception;
    
    public boolean remove(String classMethod, T entity) throws Exception;
    
    public T get(String classMethod, PK id) throws Exception;
    
    public List<T> getAll(String classMethod) throws Exception;
}