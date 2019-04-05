package com.warems.warehouse.dao;

import com.warems.warehouse.WarehouseApplication;
import com.warems.warehouse.entity.FoodRemainder;
import com.warems.warehouse.entity.Out;
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
public class OutDaoTest {
    @Resource
    private OutDao outDao;


    @Test
    public void getOne() {
        Out out = new Out();
        out.setCid(1);

        System.out.printf(outDao.getOne(out).toString());
    }

    @Test
    public void getAll() {
        System.out.printf(outDao.getAll().toString());
    }
}