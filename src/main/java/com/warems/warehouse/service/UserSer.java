package com.warems.warehouse.service;

import com.warems.warehouse.dao.UserDao;
import com.warems.warehouse.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserSer {

    @Resource
    private UserDao userDao;

    public boolean changePwd(User user){
        try {
            userDao.updatePwd(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean add(User user){
        try {
            if(userDao.getOne(user) != null){
                //邮箱唯一
                return false;
            }
            user.setCreatetime(new Date());
            userDao.add(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<User> getAll(User user){
        try {
            return userDao.getAll(user);
        }catch (Exception e){
            return null;
        }
    }

    public boolean delete(User user){
        try {
            userDao.delete(user);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public User getOne(User user){
        try {
            return  userDao.getOne(user);
        }catch (Exception e){
            return null;
        }

    }

    public boolean update(User user){
        try {
            System.out.println(user);
            userDao.update(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}
