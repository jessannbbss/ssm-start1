package com.seecen.service.impl;

import com.seecen.dao.UserMapper;
import com.seecen.entity.Page;
import com.seecen.entity.User;
import com.seecen.entity.UserExample;
import com.seecen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jessann on 2018/2/26.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Page findUserByPage(Page page, User user) {
        if(page!=null){
            if(user!=null && user.getUserName()!=null){
                user.setUserName("%"+user.getUserName()+"%");
            }
            page.setList(userMapper.findUserByPage(user, page));
            page.setTotal(userMapper.countUserByPage(user));
            return page;
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        if(user!=null){
            int i = userMapper.insert(user);
            if(i>0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Integer userId) {
        if(userId!=null){
            int i = userMapper.deleteByPrimaryKey(userId);
            return true;
        }

        return false;
    }

    @Override
    public User select(Integer userId) {

        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public boolean update(User user) {

        int i = userMapper.updateByPrimaryKey(user);
        return i>0;
    }
}
