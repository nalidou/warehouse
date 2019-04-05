package com.warems.warehouse.service;

import com.warems.warehouse.dao.FoodDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class EnterWarehouse
{
    @Resource
    private FoodDao foodDao;

    public boolean enterToWarehouse(String name,String standard,String unit, String price,String producedate,
                                    String guaranteeperid,
                                    Integer number,String posencode,String entryman,String entyrdate,
                                    String gedencode,Integer finish){

        try {
            Map map = new HashMap<String,Object>();
            map.put("fname",name);
            map.put("fstandard",standard);
            map.put("funit",unit);
            map.put("fprice",price);
            map.put("fproducedate",producedate);
            map.put("fguaranteeperiod",guaranteeperid);
            map.put("fnumber",number);
            map.put("posencode",posencode);
            map.put("entryman",entryman);
            map.put("entry_order_num",entyrdate);
            map.put("gedencode",gedencode);
            map.put("finish",finish);//0表示本次入库尚未完成，1表示本次入库的最后一个商品
            System.out.println(map);
            foodDao.entryByProcedure(map);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
