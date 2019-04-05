package com.warems.warehouse.service;

import com.warems.warehouse.dao.FoodRemainderDao;
import com.warems.warehouse.dao.GodownentrydetailDao;
import com.warems.warehouse.dao.GodownoutdetailDao;
import com.warems.warehouse.entity.FoodRemainder;
import com.warems.warehouse.entity.Godownentrydetail;
import com.warems.warehouse.entity.Godownoutdetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FoodRemanderSer {
    @Resource
    private FoodRemainderDao foodRemainderDao;
    public List<FoodRemainder> getList(){
        return  foodRemainderDao.getAll(null);
    }

    public boolean outFood(String param){
        param = param.substring(0,param.length()-1);
        String [] foodKV = param.split(";");

        try {
            for (int i=0;i<foodKV.length;i++){
                String [] fkv = foodKV[i].split(",");
                String id = fkv[0];
                String num = fkv[1];
                FoodRemainder foodRemainder2=new FoodRemainder();
                foodRemainder2.setfID(Integer.parseInt(id));
                FoodRemainder result = foodRemainderDao.getOne(foodRemainder2);
                Integer reNumber=result.getRenumber()-Integer.parseInt(num);
                foodRemainder2.setRenumber(reNumber);
                foodRemainderDao.updateRenumber(foodRemainder2);
            }
            return true;
        }catch (Exception e){
            return false;
        }


    }
}
