package com.warems.warehouse.dao;

import com.warems.warehouse.WarehouseApplication;
import com.warems.warehouse.entity.Food;
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
public class FoodDaoTest {
    @Resource
    private FoodDao foodDao;

    @Test
    public void add() {
        //Food food = new Food("苹果","箱","个",80.8f,"1990-10-01","12",20);
        //foodDao.add(food);
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void getOne() {
        Food food = new Food();
        food.setId(2);
        Food f = foodDao.getOne(food);
        System.out.printf(f.toString());
    }

    @Test
    public void getAll() {
    }
}