/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.dao;

import com.zqgame.base.Basebatis3Dao;
import com.zqgame.models.UserInfo;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alan
 */
@Repository
public class UserDaoImpl extends Basebatis3Dao<UserInfo, java.lang.Integer>  {
    @Override
    public String getIbatisSqlMapNamespace() {
        return "UserInfo";
    }
}
