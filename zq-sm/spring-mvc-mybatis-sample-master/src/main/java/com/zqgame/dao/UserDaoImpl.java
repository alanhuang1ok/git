/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.dao;

import com.zqgame.base.Basebatis3Dao;
import com.zqgame.common.page.Page;
import com.zqgame.common.page.PageRequest;
import com.zqgame.models.UserInfo;
import org.springframework.stereotype.Component;

/**
 *
 * @author alan
 */
@Component
public class UserDaoImpl extends Basebatis3Dao<UserInfo, java.lang.Integer> {

    @Override
    public String getIbatisSqlMapNamespace() {
        return "UserInfo";
    }

    public Page findByPageRequest(PageRequest pageRequest) {
        return pageQuery("UserInfo_pageSelect", pageRequest);
    }
}
