package com.warems.warehouse.dao;

import com.warems.warehouse.WarehouseApplication;
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
public class GodownentryDaoTest {

    @Resource
    private GodownentryDao godownentryDao;
    @Test
    public void getLast() {

        String s = godownentryDao.getLast().getEntry_order_number();
        String s2;

        Integer i = Integer.parseInt(s.substring(6,9));
        s2 =s.substring(0,6)+String.format("%03d",(++i))+s.substring(9,10);


    }
}