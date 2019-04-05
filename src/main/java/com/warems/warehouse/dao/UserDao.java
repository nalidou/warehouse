package com.warems.warehouse.dao;

import com.warems.warehouse.entity.User;

import java.util.List;

public interface UserDao {
    public void add(User u);
    public void delete(User u);
    public void updatePwd(User u);
    public void update(User u);
    public User getOne(User u);
    public List<User> getAll(User u);
}
