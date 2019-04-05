package com.warems.warehouse.service;

import com.warems.warehouse.dao.FoodDao;
import com.warems.warehouse.dao.FoodRemainderDao;
import com.warems.warehouse.dao.GodownentryDao;
import com.warems.warehouse.entity.FoodRemainder;
import com.warems.warehouse.entity.Godownentry;
import com.warems.warehouse.util.ImportExecl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 入库操作、入库查询
 * */
@Service
public class EnterWarehouse
{
    @Resource
    private FoodDao foodDao;
    @Resource
    private GodownentryDao godownentryDao;
    @Resource
    private FoodRemainderDao foodRemainderDao;

    //手动入库
    @Transactional
    public boolean inWareHouse(String param,String userName){
        try {
            param = param.substring(0,param.length()-1);
            String [] list = param.split(";");

            Godownentry g = godownentryDao.getLast();
            String lastEnterOrderNum = null;
            if(g==null){
                lastEnterOrderNum = "2018年第001号";
            }else {
                lastEnterOrderNum= g.getEntry_order_number();
                Integer n = Integer.parseInt(lastEnterOrderNum.substring(6,9));
                lastEnterOrderNum = lastEnterOrderNum.substring(0,6)
                        +String.format("%03d",(++n))
                        +lastEnterOrderNum.substring(9,10);
            }

            for (int i=0;i<list.length;i++){
                String [] item = list[i].split(":");

                Map map = new HashMap<String,Object>();
                map.put("fname",item[0]);
                map.put("fstandard",item[1]);
                map.put("funit",item[2]);
                map.put("fprice",item[3]);
                map.put("fproducedate",item[4]);
                map.put("fguaranteeperiod",item[5]);
                map.put("fnumber",item[6]);
                map.put("posencode",item[7]);
                map.put("entryman",userName);
                map.put("entry_order_num",lastEnterOrderNum);
                map.put("gedencode","null");//弃用
                if(i==list.length-1){//0表示本次入库尚未完成，1表示本次入库的最后一个商品
                    map.put("finish",1);
                }else {
                    map.put("finish",0);
                }

                foodDao.entryByProcedure(map);

            }
            return true;
        }catch (Exception e){
            //e.printStackTrace();
            throw new RuntimeException("手动入库异常");

        }
    }

    //批量入库
    @Transactional
    public boolean inWareHouseBash(InputStream inputStream,String userName){
        try {
            Godownentry g = godownentryDao.getLast();
            String lastEnterOrderNum = null;
            //System.out.println(g);
            if(g==null){
                lastEnterOrderNum = "2018年第001号";
            }else {
                lastEnterOrderNum= g.getEntry_order_number();
                Integer n = Integer.parseInt(lastEnterOrderNum.substring(6,9));
                lastEnterOrderNum = lastEnterOrderNum.substring(0,6)
                        +String.format("%03d",(++n))
                        +lastEnterOrderNum.substring(9,10);
            }

            ImportExecl poi = new ImportExecl();
            List<List<String>> list = poi.read(inputStream,true);

            if (list != null) {
                for (int i = 1; i < list.size(); i++) {
                    List<String> cellList = list.get(i);
                    Map map = new HashMap<String,Object>();

                    map.put("entryman",userName);
                    map.put("entry_order_num",lastEnterOrderNum);
                    map.put("gedencode","null");//弃用
                    if(i==list.size()-1){//0表示本次入库尚未完成，1表示本次入库的最后一个商品
                        map.put("finish",1);
                    }else {
                        map.put("finish",0);
                    }

                    for (int j = 0; j < cellList.size(); j++) {
                        //System.out.print(cellList.get(j));
                        switch (j){
                            case 0:
                                map.put("fname",cellList.get(j));
                                break;
                            case 1:
                                map.put("fstandard",cellList.get(j));
                                break;
                            case 2:
                                map.put("funit",cellList.get(j));
                                break;
                            case 3:
                                map.put("fprice",cellList.get(j));
                                break;
                            case 4:
                                map.put("fproducedate",cellList.get(j));
                                break;
                            case 5:
                                map.put("fguaranteeperiod",cellList.get(j));
                                break;
                            case 6:
                                map.put("fnumber",cellList.get(j));
                                break;
                            case 7:
                                map.put("posencode",cellList.get(j));
                                break;
                                default:
                                    break;
                        }

                    }
                    foodDao.entryByProcedure(map);

                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("批量入库异常");
        }
    }

    //得到批次列表
    public List<Godownentry> getGoDownEntryList(Godownentry g){
        return godownentryDao.getAll(g);
    }

    //根据入库单号查询对应的详单列表
    public List<FoodRemainder> getFoodRemainderList(String entryNum){
        FoodRemainder foodRemainder = new FoodRemainder();
        foodRemainder.setGe_entry_order_number(entryNum);
        return foodRemainderDao.getAll(foodRemainder);
    }

    //根据入库单号查询对应的详单列表
    public List<FoodRemainder> getFoodList(String name){
        FoodRemainder foodRemainder = new FoodRemainder();
        foodRemainder.setName(name);
        List<FoodRemainder> list = foodRemainderDao.getAll(foodRemainder);

        List<FoodRemainder> newList = new ArrayList<FoodRemainder>();
        merge(list,newList);//合并
        //System.out.println(list.size());
        //System.out.println(newList.size());
        return  newList;
    }

    //食品列表重复合并
    private void merge(List<FoodRemainder> list,List<FoodRemainder> newList){
        newList.add(list.get(0));
        for(int i=0;i<list.size();i++){
            for(int j=0;j<newList.size();j++){
                if(newList.get(j).getName().equals(list.get(i).getName())
                        &&newList.get(j).getStandard().equals(list.get(i).getStandard())){
                    break;
                }
                if(j == newList.size()-1){
                    newList.add(list.get(i));
                }
            }
        }

        List<FoodRemainder> beifen  = new ArrayList();
        for(FoodRemainder p:newList){
            beifen.add(p.clone());
        }

        for(int i=0;i<newList.size();i++){
            for(int j=0;j<list.size();j++){
                if(newList.get(i).getName().equals(list.get(j).getName())
                        &&newList.get(i).getStandard().equals(list.get(j).getStandard())){
                    newList.get(i).setRenumber(newList.get(i).getRenumber()+list.get(j).getRenumber());
                }
            }
        }
        for(int i=0;i<newList.size();i++){
            newList.get(i).setRenumber(newList.get(i).getRenumber()-beifen.get(i).getRenumber());
        }


    }
}
