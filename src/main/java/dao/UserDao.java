package dao;

import entity.User;

import java.util.List;

public interface UserDao {

    //查询所有用户
    List<User> all();
}
