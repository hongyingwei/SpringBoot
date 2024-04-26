package com.jsu.greet.dao;

import com.jsu.greet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
//    @Select("SELECT * FROM t_user WHERE user_name=#{username} AND password=#{password}")
    User findUserByUsernameAndPassword(String username, String password);

//    @Select("SELECT * FROM t_user")
//    List<User> findAllUsers();

//    @Delete("DELETE FROM t_user WHERE id=#{value}")
//    int del(int id);
}
