package com.warems.warehouse.ctl;

import com.warems.warehouse.entity.FoodRemainder;
import com.warems.warehouse.entity.Godownentry;
import com.warems.warehouse.entity.PageQueryBean;
import com.warems.warehouse.entity.User;
import com.warems.warehouse.service.EnterWarehouse;
import com.warems.warehouse.service.FoodRemanderSer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("food-remander")
public class FoodRemanderCtl {

    @Resource
    private FoodRemanderSer foodRemanderSer;

    @RequestMapping("get-list")
    public Map getList(){
        Map map = new HashMap<String,Object>();
        List<FoodRemainder> list = foodRemanderSer.getList();
        map.put("state",1);
        map.put("size",list.size());
        map.put("list",list);
        return map;
    }

    @RequestMapping("out-food")
    public Map outFood(String param){
        Map map = new HashMap<String,Object>();
        if(foodRemanderSer.outFood(param)){
            map.put("state",1);
        }else {
            map.put("state",0);
        }

        return map;
    }

    @Resource
    private EnterWarehouse enterWarehouse;


    //手动入库
    @RequestMapping("in-warehouse")
    public Map inWarehouse(String param, HttpSession session){
        Map map = new HashMap();
        if(enterWarehouse.inWareHouse(param,((User)session.getAttribute("sysUser")).getName())){
            map.put("state",1);
        }else {
            map.put("state",0);
        }
        return map;
    }

    //批量入库
    @RequestMapping("in-warehouse-bash")
    public Map inWarehouseBash(@RequestParam(value="file") MultipartFile file,
                               HttpServletRequest request,
                               HttpServletResponse response, HttpSession session) throws IOException {

        Map map = new HashMap();
        try {

            if(enterWarehouse.inWareHouseBash(file.getInputStream(),
                    ((User)session.getAttribute("sysUser")).getName())){
                map.put("state",1);
            }else {
                map.put("state",0);
            }
        }catch (Exception e){
            map.put("state",0);
        }

        return map;
    }

    //获取入库单批次列表
    @RequestMapping("list-godownentry")
    public PageQueryBean getGoDownEntryList(Godownentry godownentry){
        PageQueryBean pageQueryBean = new PageQueryBean();
        List<Godownentry> godownentryList = enterWarehouse.getGoDownEntryList(godownentry);
        pageQueryBean.setItems(godownentryList);
        pageQueryBean.setTotalRows(godownentryList.size());
        return pageQueryBean;
    }

    @RequestMapping("write-entry-order-number")
    public Map writeEntryOrderNumber(String num, HttpSession session){
        Map map = new HashMap<String,Object>();
        session.setAttribute("entry-num",num);

        map.put("state",1);
        return map;
    }

    //根据从session中取得订单号，查询对应的所有数据
    @RequestMapping("get-entry-order-detail")
    public PageQueryBean getEntryOrderDetail(HttpSession session){
        PageQueryBean pageQueryBean = new PageQueryBean();
        String entryNum = String.valueOf(session.getAttribute("entry-num"));
        List<FoodRemainder> list = enterWarehouse.getFoodRemainderList(entryNum);
        System.out.println(list.size());
        if(list != null && list.size()!=0){
            pageQueryBean.setItems(list);
            pageQueryBean.setTotalRows(list.size());
            pageQueryBean.map.put("entryNum",entryNum);
            pageQueryBean.map.put("entryMan",list.get(0).getEntryman());
        }else {
            pageQueryBean.setItems(null);
            pageQueryBean.setTotalRows(0);
            pageQueryBean.map.put("entryNum",entryNum);
            pageQueryBean.map.put("entryMan","数据暂无");
        }
        return pageQueryBean;
    }

    //得到食品列表
    @RequestMapping("get-food-list")
    public PageQueryBean getFoodList(String name){
        PageQueryBean pageQueryBean = new PageQueryBean();

        List<FoodRemainder> list = enterWarehouse.getFoodList(name);
        if(list != null && list.size()!=0){
            pageQueryBean.setItems(list);
            pageQueryBean.setTotalRows(list.size());

        }else {
            pageQueryBean.setItems(null);
            pageQueryBean.setTotalRows(0);

        }


        return pageQueryBean;

    }


}
