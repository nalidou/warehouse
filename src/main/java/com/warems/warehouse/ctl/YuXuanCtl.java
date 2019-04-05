package com.warems.warehouse.ctl;

import com.warems.warehouse.entity.PageQueryBean;
import com.warems.warehouse.entity.User;
import com.warems.warehouse.entity.YuXuan;
import com.warems.warehouse.entity.YuXuanDetail;
import com.warems.warehouse.service.YuXuanSer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("yuxuan")
public class YuXuanCtl {
    @Resource
    private YuXuanSer yuXuanSer;

    @RequestMapping("save")
    public Map save(String param, HttpSession session){
        Map map = new HashMap<String,Object>();
        User user = (User)session.getAttribute("sysUser");

        String perOrderNum = yuXuanSer.save(param,user.getName());
        if(perOrderNum != null){
            map.put("state",1);
            session.setAttribute("perOrderNum",perOrderNum);
        }else {
            map.put("state",0);
        }
        return map;
    }

    @RequestMapping("getYuXuanDetail")
    public Map getYuXuanDetail(HttpSession session){
        Map map = new HashMap<String,Object>();
        String perOrderNum = (String) session.getAttribute("perOrderNum");
        List<YuXuanDetail> list = yuXuanSer.getYuXuanDetailByOrderNum(perOrderNum);
        map.put("list",list);
        map.put("size",list.size());
        return map;
    }
    @RequestMapping("getYuxuanList")
    public PageQueryBean getYuxuanList(YuXuan yuXuan){
        PageQueryBean pageQueryBean = new PageQueryBean();
        List<YuXuan> list = yuXuanSer.getYuXuanList(yuXuan);
        //System.out.println(list);
        pageQueryBean.setItems(list);
        pageQueryBean.setTotalRows(list.size());
        return pageQueryBean;

    }
    @RequestMapping("writePerOrderNum")
    public Map writePerOrderNum(String orderNum ,HttpSession session){

        session.setAttribute("perOrderNum",orderNum);
        return new HashMap();
    }



}
