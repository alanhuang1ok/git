/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zqgame.service;

import com.zqgame.models.UserInfo;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alan
 */

public interface IUserService {
    public UserInfo getModel(int id);
}
