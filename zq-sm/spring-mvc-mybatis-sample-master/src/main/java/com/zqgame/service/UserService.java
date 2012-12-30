/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.service.impl;

import com.zqgame.dao.impl.UserDaoImpl;
import com.zqgame.models.UserInfo;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alan
 */
@Service
public class UserService {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDaoImpl userDaoImpl;

    public UserInfo getModel(int id) {
        UserInfo info = new UserInfo();
        System.out.println("getModel");

        try {
            info = userDaoImpl.get(new Integer(1));
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
        return info;
    }

    public List<UserInfo> getAllList() {
        List<UserInfo> all = null;
        try {
            all = userDaoImpl.getAll();
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
        return all;
    }

    public boolean createUserInfo(UserInfo info) {
        boolean result = false;
        int resultInt = -1;
        try {
            resultInt = userDaoImpl.add(info);
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
        return result;
    }
}
