/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.dao.impl;

import com.zqgame.framework.Mybatis3Dao;
import com.zqgame.models.UserInfo;
import javax.annotation.Resource;

/**
 *
 * @author alan
 */
@Resource
public class UserDaoImpl extends Mybatis3Dao<UserInfo, java.lang.Integer> {

    @Override
    public String getIbatisSqlMapNamespace() {
        return "UserInfo";
    }
}
