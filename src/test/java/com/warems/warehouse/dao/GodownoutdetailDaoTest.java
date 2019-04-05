package com.warems.warehouse.dao;

import com.warems.warehouse.WarehouseApplication;
import com.warems.warehouse.entity.Godownoutdetail;
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
public class GodownoutdetailDaoTest {
    @Resource
    private GodownoutdetailDao godownoutdetailDao;
    @Test
    public void add() {
        try {
            Godownoutdetail godownoutdetail = new Godownoutdetail("2018001001",8,2,"001,008,2");
            godownoutdetailDao.add(godownoutdetail);
        }catch (Exception e)
        {e.printStackTrace();

        }
    }

    @Test
    public void update() {

       // Godownoutdetail godownoutdetail=new Godownoutdetail(1,"2018001002",9,3,"001,008,2");
        //godownoutdetailDao.update(godownoutdetail);
    }
}