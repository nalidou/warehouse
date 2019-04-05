package com.warems.warehouse.dao;

import com.warems.warehouse.WarehouseApplication;
import com.warems.warehouse.entity.Check;
import com.warems.warehouse.entity.CheckList;
import com.warems.warehouse.entity.Food;
import com.warems.warehouse.entity.Godownout;
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

public class CheckDaoTest {
    @Resource
    private CheckDao checkDao;


    @Test
    public void add() {
        CheckList checkList = new CheckList();
        checkList.setName("aa");
        checkList.setStandard("aa");
        checkList.setPosencode("aa");
        System.out.println(checkDao.getCheckList(checkList).size());
        //Check check=new Check(1,"200","haha",new Date());
        //checkDao.add(check);
    }

    @Test
    public void delete() {
        Check check=new Check(1,"200","haha",new Date());
        checkDao.delete(check);
    }


    @Test
    public void getOne() {
        Check check = new Check();
        check.setId(1);
        Check c = checkDao.getOne(check);
        System.out.printf(c.toString());
    }

    @Test
    public void getAll() {
        System.out.printf(checkDao.getAll().toString());
    }

}
