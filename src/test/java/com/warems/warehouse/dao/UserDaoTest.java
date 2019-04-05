package com.warems.warehouse.dao;

import com.warems.warehouse.WarehouseApplication;
import com.warems.warehouse.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = WarehouseApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)


public class UserDaoTest {

    @Resource
    private UserDao userDao;
    @Test
    public void add() {
    }

    @Test
    public void updatePwd() {
        User user = new User();
        user.setMail("123");
        User u = userDao.getOne(user);
        System.out.println(u == null);
    }

    @Test
    public void getOne() {
    }

    @Test
    public void getAll() {
    }
}