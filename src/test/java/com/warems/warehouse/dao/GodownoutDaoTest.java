package com.warems.warehouse.dao;

import com.warems.warehouse.WarehouseApplication;
import com.warems.warehouse.entity.Godownout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = WarehouseApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class GodownoutDaoTest
{
@Resource
    private GodownoutDao godownoutDao;
@Test
    public void add(){
        Godownout godownout=new Godownout("2018年第001号","2018年第001号",new Date(),new Date(),"已出库","吴彦祖","彭于晏","2018001001");
        godownoutDao.add(godownout);
    }

}