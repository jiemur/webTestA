package com.wzn.dao;

import com.wzn.pojo.User;
import com.wzn.utilTest.JdbcUtil;
import com.wzn.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {

    @Override
    public int insert(User user) {
        return JdbcUtil.executUpdate("insert into user(username,password,tele) value(?,?,?)",user.getUsername(),user.getPassword(),user.getTele());
    }

    @Override
    public User getOne(String username) {
        return JdbcUtil.queteOne("select username,password,tele from user where username=?", new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet rs) {
                User u=new User();
                try {
                  u.setUsername(rs.getString("username"));
                  u.setPassword(rs.getString("password"));
                  u.setTele(rs.getString("tele"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return u;
            }
        }, username);
    }
}
