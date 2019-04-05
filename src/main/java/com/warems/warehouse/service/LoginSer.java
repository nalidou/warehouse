package com.warems.warehouse.service;

import com.warems.warehouse.dao.UserDao;
import com.warems.warehouse.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginSer {
    @Resource
    private UserDao userDao;

    public User login(User user){
        User u = userDao.getOne(user);
        try {//防止sql注入
            if(user.getPassword().equals(u.getPassword())){
                return u;
            }
            return null;
        }catch (Exception e){
           // e.printStackTrace();
            return null;
        }
    }
}
