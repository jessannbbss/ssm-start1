package com.seecen.service;

import com.seecen.entity.Page;
import com.seecen.entity.User;

/**
 * Created by jessann on 2018/2/26.
 */
public interface UserService {
/*分页查询*/
    public Page findUserByPage(Page page, User user);

    /*增加用户名*/
    boolean addUser(User user);
    /*删除用户*/
    boolean delete(Integer userId);
    /*查询*/
     User select(Integer userId);
     /*更新*/
     boolean update(User user);
}
