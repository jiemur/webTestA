package com.wzn.service;

import com.wzn.dao.IUserDao;
import com.wzn.dao.UserDaoImpl;
import com.wzn.pojo.User;

public class UserServiceImpl implements IUserService {
    private IUserDao dao=new UserDaoImpl();
    @Override
    public int insert(User user) {
        return dao.insert(user);
    }

    @Override
    public User getOne(String username) {
        return dao.getOne(username);
    }
}
