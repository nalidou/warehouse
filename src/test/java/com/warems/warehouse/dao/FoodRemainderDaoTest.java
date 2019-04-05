package com.warems.warehouse.dao;

import com.warems.warehouse.WarehouseApplication;
import com.warems.warehouse.entity.FoodRemainder;
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
public class FoodRemainderDaoTest {
    public Integer outNumber;
    public Integer reNumber;
    @Resource
    private FoodRemainderDao foodRemainderDao;
    @Test

    public void update()
    {/*
        FoodRemainder foodRemainder2=new FoodRemainder();
        foodRemainder2.setfID(4);
        FoodRemainder result = foodRemainderDao.getOne(foodRemainder2);
        outNumber=10;
        reNumber=result.getRenumber()-outNumber;
        foodRemainder2.setRenumber(reNumber);
        foodRemainderDao.update(foodRemainder2);
        */
        String str = "abcdefg;";
        System.out.printf(str);
        String s = str.substring(0,str.length()-1);
        System.out.printf("  "+s);
    }

    @Test
    public void getOne() {
        FoodRemainder foodRemainder=new FoodRemainder();
        foodRemainder.setfID(4);
        System.out.printf(foodRemainderDao.getOne(foodRemainder).toString());
    }

    @Test
    public void getAll()
    {
        FoodRemainder foodRemainder=new FoodRemainder();
        foodRemainder.setGe_entry_order_number("2018年第008号");
        System.out.printf(foodRemainderDao.getAll(foodRemainder).size()+"");

    }
}