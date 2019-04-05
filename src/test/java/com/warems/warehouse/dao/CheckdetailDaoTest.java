package com.warems.warehouse.dao;

import com.warems.warehouse.WarehouseApplication;
import com.warems.warehouse.entity.Check;
import com.warems.warehouse.entity.Checkdetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = WarehouseApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class CheckdetailDaoTest {
    @Resource
    private CheckdetailDao checkdetailDao;
    @Test
    public void add() {
        Checkdetail checkdetail=new Checkdetail(1,"200",1,1,1,1,"2001","200","haha");
        checkdetailDao.add(checkdetail);
    }

    @Test
    public void delete(){
        Checkdetail checkdetail=new Checkdetail(1,"200",1,1,1,1,"2001","200","haha");
        checkdetailDao.delete(checkdetail);
    }

    @Test
    public void getOne() {
        Checkdetail checkdetail = new Checkdetail();
        checkdetail.setId(1);
        Checkdetail c = checkdetailDao.getOne(checkdetail);
        System.out.printf(c.toString());
    }

    @Test
    public void getAll() {
        System.out.printf(checkdetailDao.getAll().toString());
    }

}
