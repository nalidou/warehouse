package com.warems.warehouse.service;

import com.warems.warehouse.dao.YuXuanDao;
import com.warems.warehouse.dao.YuXuanDetailDao;
import com.warems.warehouse.entity.YuXuan;
import com.warems.warehouse.entity.YuXuanDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class YuXuanSer {
    @Resource
    private YuXuanDao yuXuanDao;
    @Resource
    private YuXuanDetailDao yuXuanDetailDao;

    @Transactional
    public String save(String param, String userName){
        try {
            param = param.substring(0,param.length()-1);
            String [] foodKV = param.split(";");
            String orderNum = null;
            YuXuan res = yuXuanDao.getLast();
            if(res == null){
                orderNum = "20181010001";
            }else {
                orderNum = res.getYx_preorder_number();
                String pre = orderNum.substring(0,orderNum.length()-3);
                String aft = orderNum.substring(orderNum.length()-3,orderNum.length());

                orderNum = pre + String.format("%03d",(Integer.parseInt(aft)+1));
            }
            YuXuan yuXuan = new YuXuan();
            yuXuan.setYx_agent(userName);
            yuXuan.setYx_createdate(new Date());
            yuXuan.setYx_preorder_number(orderNum);
            yuXuan.setState(0);
            yuXuanDao.addOne(yuXuan);

            for (int i=0;i<foodKV.length;i++){
                String [] fkv = foodKV[i].split(":");
                YuXuanDetail yuXuanDetail = new YuXuanDetail();
                yuXuanDetail.setYxd_preorder_number(orderNum);
                yuXuanDetail.setYxd_foodname(fkv[0]);
                yuXuanDetail.setYxd_foodstandard(fkv[1]);
                yuXuanDetail.setYxd_num(Integer.parseInt(fkv[2]));

                yuXuanDetailDao.addOne(yuXuanDetail);

            }
            return orderNum;
        }catch (Exception e){
            e.printStackTrace();
            //在事物处理中，出现异常要往外抛，不然事物不起作用
            throw new RuntimeException("预选入库失败");

        }
    }

    public List<YuXuanDetail> getYuXuanDetailByOrderNum(String orderNum){
        YuXuanDetail yuXuanDetail = new YuXuanDetail();
        yuXuanDetail.setYxd_preorder_number(orderNum);
        return yuXuanDetailDao.getAll(yuXuanDetail);
    }

    public List<YuXuan> getYuXuanList(YuXuan yuXuan){
        return yuXuanDao.getAll(yuXuan);

    }
}
