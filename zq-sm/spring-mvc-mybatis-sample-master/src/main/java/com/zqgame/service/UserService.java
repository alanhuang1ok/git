/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.service;
 
import com.zqgame.common.page.Page;
import com.zqgame.common.page.PageRequest;
import com.zqgame.dao.UserDaoImpl;
import com.zqgame.models.UserInfo;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author alan
 */
@Component
public class UserService {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDaoImpl userDaoImpl;

    public UserInfo getModel(int id) {
        UserInfo info = new UserInfo();
        LOG.info("getModel");
        try {
            info = getUserDaoImpl().get(new Integer(1));
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
        return info;
    }

    public List<UserInfo> getAllList() {
        List<UserInfo> all = null;
        try {
            all = getUserDaoImpl().getAll();
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
        return all;
    }

    public boolean createUserInfo(UserInfo info) {
        boolean result = false;
        int resultInt = -1;
        try {
            resultInt = getUserDaoImpl().add(info);
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
        return result;
    }

    /**
     * @return the userDaoImpl
     */
    public UserDaoImpl getUserDaoImpl() {
        return userDaoImpl;
    }

    /**
     * @param userDaoImpl the userDaoImpl to set
     */
    @Resource    
    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public Page findByPageRequest(PageRequest<Map> pageRequest) {
       return userDaoImpl.findByPageRequest(pageRequest);
    }
}
