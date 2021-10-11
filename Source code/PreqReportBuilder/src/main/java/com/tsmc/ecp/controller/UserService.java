/**
 * 
 */
package com.tsmc.ecp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Component;

import com.tsmc.ecp.dao.UserDao;
import com.tsmc.ecp.model.User;

/**
 * 
 */
@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

}
