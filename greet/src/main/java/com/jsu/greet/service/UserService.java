package com.jsu.greet.service;

import com.jsu.greet.entity.User;
import com.jsu.greet.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Resource
    UserDao dao;

    public boolean checkUser(User u) {
        return dao.findUserByUsernameAndPassword(u.getUsername(), u.getPassword()) != null;
//        return dao.findUserByUsernameAndPassword(u) != null;
//        return "1".equals(u.getPassword()) && "zhao".equals(u.getUsername());
    }

    public List<User> findAllUsers() {
//        return dao.findAllUsers();
        return dao.findAll();
    }

    public boolean del(int id) {
//        return dao.del(id) == 1;
        try {
            dao.deleteById(id);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String reg(User u) {
        if (u.getPassword().equals(u.getPassword2())) {
            dao.save(u);
            return null;
        }
        return "两次输入的密码不匹配";
    }
}
