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

        return  foodRemainderDao.getAll();
    }
    @Resource
    private GodownentrydetailDao godownentrydetailDao;
    private GodownoutdetailDao godownoutdetailDao;
    public boolean outFood(String param)
    {
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
                foodRemainderDao.update(foodRemainder2);

                Godownentrydetail entryFood=new Godownentrydetail();
                entryFood.setId(Integer.parseInt(id));
                Godownentrydetail godownentrydetail= godownentrydetailDao.getOne(entryFood);

                Godownentrydetail entryFood=new Godownentrydetail();
                entryFood.setId(Integer.parseInt(id));
                Godownentrydetail godownentrydetail= godownentrydetailDao.getOne(entryFood);

                Godownoutdetail outFood=new Godownoutdetail();
                outFood.setEncode(godownentrydetail.getEncod());
                outFood.setFoodid(godownentrydetail.getFoodid());
                outFood.setPosencode(godownentrydetail.getPosencode());
                outFood.setOutnum(Integer.parseInt(num));

                godownoutdetailDao.add(outFood);

                /*
            @Resource
            private GodownentrydetailDao godownentrydetailDao;
            private GodownoutdetailDao godownoutdetailDao;

                Godownentrydetail entryFood=new Godownentrydetail();
                entryFood.setId(Integer.parseInt(id));
                Godownentrydetail godownentrydetail= godownentrydetailDao.getOne(entryFood);
                  1.根据食物ID得到对应的食物详单类
                Godownentrydetail entryFood=new Godownentrydetail();
                entryFood.setId(Integer.parseInt(id));
                Godownentrydetail godownentrydetail= godownentrydetailDao.getOne(entryFood);
                  2.把食品详单类的属性赋值给对应的出库食品详单类
                Godownoutdetail outFood=new Godownoutdetail();
                outFood.setEncode(godownentrydetail.getEncod());
                outFood.setFoodid(godownentrydetail.getFoodid());
                outFood.setPosencode(godownentrydetail.getPosencode());
                outFood.setOutnum(Integer.parseInt(num));
                  3.执行出库详单add方法
                godownoutdetailDao.add(outFood);

                 */
            }
            return true;
        }catch (Exception e){
            return false;
        }


    }
}
