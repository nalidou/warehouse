package com.warems.warehouse.service;

import com.warems.warehouse.WarehouseApplication;
import com.warems.warehouse.dao.FoodDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = WarehouseApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class EnterWarehouseTest {

    @Resource
    private EnterWarehouse enterWarehouse;
    @Resource
    private FoodDao foodDao;
    @Test
    public void enterToWarehouse() {
        /*`pro_entry`("苹果","640ml/瓶x12瓶/箱","瓶","10.89","2016年12","12个月",60,"001,324,1","陈世宽","2018年第01号","1539090424609",0,@res);

         */
        Map map = new HashMap<String,Object>();
        map.put("fname","红牛");
        map.put("fstandard","箱");
        map.put("funit","瓶");
        map.put("fprice","8");
        map.put("fproducedate","2017年12");
        map.put("fguaranteeperiod","12个月");
        map.put("fnumber",60);
        map.put("posencode","001,008,1");
        map.put("entryman","蔡徐坤");
        map.put("entry_order_num","2018年第001号");
        map.put("gedencode","20181024002");
        map.put("finish",0);//0表示本次入库尚未完成，1表示本次入库的最后一个商品
        foodDao.entryByProcedure(map);
        //enterWarehouse.enterToWarehouse();
    }
}