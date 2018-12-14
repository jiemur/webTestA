package com.wzn.service;

import com.wzn.pojo.User;

public interface IUserService {
    public int insert(User user);
    public User getOne(String username);

}
