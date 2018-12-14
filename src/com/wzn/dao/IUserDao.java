package com.wzn.dao;

import com.wzn.pojo.User;

public interface IUserDao {
    public int insert(User user);
    public User getOne(String username);
}
