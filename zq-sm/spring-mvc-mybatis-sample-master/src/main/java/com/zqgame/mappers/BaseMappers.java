/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.mappers;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.noo.pagination.page.Page;

/**
 *
 * @author alan
 */
public interface BaseMappers<T, PK extends Serializable> {

    T findById(@Param("id") PK id);

    int save(T model);

    List<T> findAllBlogs(Page tag);
}
