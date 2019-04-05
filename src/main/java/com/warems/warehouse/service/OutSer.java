package com.warems.warehouse.service;

import com.warems.warehouse.dao.*;
import com.warems.warehouse.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OutSer {

    @Resource
    private FoodRemainderDao foodRemainderDao;
    @Resource
    private YuXuanDetailDao yuXuanDetailDao;
    @Resource
    private YuXuanDao yuXuanDao;
    @Resource
    private ChukuDao chukuDao;
    @Resource
    private ChukuDetailDao chukuDetailDao;

    public List<FoodRemainder> getChukuList(String orderNum){
        YuXuanDetail yuXuanDetail = new YuXuanDetail();
        yuXuanDetail.setYxd_preorder_number(orderNum);
        List<YuXuanDetail> yuXuanDetailList = yuXuanDetailDao.getAll(yuXuanDetail);
        List<FoodRemainder> chukuList = new ArrayList<FoodRemainder>();
        for(YuXuanDetail y:yuXuanDetailList){
            FoodRemainder foodRemainder = new FoodRemainder();
            foodRemainder.setName(y.getYxd_foodname());
            foodRemainder.setStandard(y.getYxd_foodstandard());
            List<FoodRemainder> foodRemainderList = foodRemainderDao.getAll(foodRemainder);
            Integer yuxuanNum = y.getYxd_num();//预选数量
            Integer nextNum = yuxuanNum;
            for(FoodRemainder f:foodRemainderList){
                Integer kucunNum = f.getRenumber();//本货架剩余数量
                if(!kucunNum.equals(0) && !nextNum.equals(0)){
                    if(kucunNum >= yuxuanNum){
                        f.setOutNum(yuxuanNum);
                        chukuList.add(f);
                        //库存大于预选
                        break;
                    }else {
                        //这个货架出完，nextNum的数量留给下个货架出
                        nextNum = nextNum - kucunNum;
                        f.setOutNum(kucunNum);
                        chukuList.add(f);
                    }
                }
            }


        }

        return chukuList;
    }


    //出库操作
    @Transactional
    public String chuku(String param,String userName,String perOrderNum){
        try {
            param = param.substring(0,param.length()-1);
            String [] foodKV = param.split(";");
            String orderNum = null;
            Chuku res = chukuDao.getLast();
            if(res == null){
                orderNum = "2018年第001号";
            }else {
                orderNum= res.getOut_num();
                Integer n = Integer.parseInt(orderNum.substring(6,9));
                orderNum = orderNum.substring(0,6)
                        +String.format("%03d",(++n))
                        +orderNum.substring(9,10);
            }
            Chuku chuku = new Chuku();
            chuku.setAgent(userName);
            chuku.setCreatedate(new Date());
            chuku.setOut_num(orderNum);
            chukuDao.addOne(chuku);//添加出库单

            //设置预选单状态
            YuXuan y = new YuXuan();
            y.setYx_preorder_number(perOrderNum);
            y.setState(1);
            yuXuanDao.updateState(y);


            for (int i=0;i<foodKV.length;i++){//添加出库详单
                String [] fkv = foodKV[i].split(":");
                String id = fkv[0];
                String num = fkv[1];
                FoodRemainder f = new FoodRemainder();
                f.setfID(Integer.parseInt(id));
                FoodRemainder foodRemainder = foodRemainderDao.getOne(f);
                ChukuDetail chukuDetail = new ChukuDetail();
                chukuDetail.setOut_num(orderNum);
                chukuDetail.setFood_id(String.valueOf(foodRemainder.getfID()));
                chukuDetail.setFood_name(foodRemainder.getName());
                chukuDetail.setFood_standard(foodRemainder.getStandard());
                chukuDetail.setFood_unit(foodRemainder.getUnit());
                chukuDetail.setFood_num(num);
                chukuDetail.setFood_price(String.valueOf(foodRemainder.getPrice()));
                chukuDetail.setFood_total(String.valueOf(Integer.parseInt(num) * foodRemainder.getPrice()));
                chukuDetail.setFood_time(new Date());
                chukuDetail.setOutman(userName);
                chukuDetail.setFood_poscode(foodRemainder.getPosencode());
                chukuDetailDao.addOne(chukuDetail);

                FoodRemainder f1 = new FoodRemainder();
                f1.setfID(f.getfID());
                f1.setRenumber(foodRemainder.getRenumber()-Integer.parseInt(num));
                foodRemainderDao.updateRenumber(f1);

            }

            return orderNum;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<ChukuDetail> getChukuDeatil(String outNum){
        ChukuDetail chukuDetail = new ChukuDetail();
        chukuDetail.setOut_num(outNum);
        return chukuDetailDao.getAll(chukuDetail);
    }

    public List<Chuku> getChukuOrderList(){
        return chukuDao.getAll(null);
    }

    @Deprecated
    public List<FoodRemainder> getListByNameStd(String name,String std){
        FoodRemainder foodRemainder = new FoodRemainder();
        foodRemainder.setName(name);
        foodRemainder.setStandard(std);
        System.out.println(foodRemainder);
        List list = foodRemainderDao.getAll(foodRemainder);
        if(list!=null){
            return list;
        }else {
            return null;
        }
    }
}
