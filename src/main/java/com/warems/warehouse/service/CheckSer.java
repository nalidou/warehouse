package com.warems.warehouse.service;

import com.warems.warehouse.dao.CheckDao;
import com.warems.warehouse.dao.CheckDetail2Dao;
import com.warems.warehouse.dao.FoodRemainderDao;
import com.warems.warehouse.entity.Check;
import com.warems.warehouse.entity.CheckDetail2;
import com.warems.warehouse.entity.CheckList;
import com.warems.warehouse.entity.FoodRemainder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CheckSer {
    @Resource
    private CheckDao checkDao;
    @Resource
    private CheckDetail2Dao checkDetail2Dao;

    @Transactional//进行盘点
    public String doCheck(CheckList param, String userName){
        try {
            List<CheckList> checkList = checkDao.getCheckList(param);
            Check check = checkDao.getLast();
            String code = null;
            if(check==null){
                code = "2018年第001号";
            }else {
                code = check.getEncode();
                Integer n = Integer.parseInt(code.substring(6,9));
                code = code.substring(0,6)
                        +String.format("%03d",(++n))
                        +code.substring(9,10);
            }
            check = new Check();
            check.setEncode(code);
            check.setCheckman(userName);
            check.setCheckdate(new Date());
            checkDao.add(check);

            for(CheckList c : checkList){
                CheckDetail2 checkDetail2 = new CheckDetail2(code,
                        c.getName(),c.getStandard(),c.getUnit(),
                        c.getEnnumber(),c.getOutnumber(),c.getRenumber(),
                        c.getPrice(),c.getProducedate(),c.getPosencode(),
                        new Date(),userName);
                checkDetail2Dao.add(checkDetail2);

            }
            return code;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("盘点异常");
        }
    }

    //得到盘点列表
    public List<Check> getCheckList(){
        return  checkDao.getAll();
    }
    public List<CheckDetail2> getCheckDetail(String code){
        CheckDetail2 c = new CheckDetail2();
        c.setCk_num(code);
        return  checkDetail2Dao.getAll(c);

    }

}
