package com.warems.warehouse.ctl;

import com.warems.warehouse.entity.Chuku;
import com.warems.warehouse.entity.FoodRemainder;
import com.warems.warehouse.entity.PageQueryBean;
import com.warems.warehouse.entity.User;
import com.warems.warehouse.service.OutSer;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("out")
public class OutCtl {

    @Resource
    private OutSer outSer;
    @RequestMapping("getFoodByNameStd")
    @Deprecated
    public Map getFoodByNameStd(String name,String std){
        Map map = new HashMap<String,Object>();
        List<FoodRemainder> list = outSer.getListByNameStd(name,std);
        if(list != null){
            for(FoodRemainder f:list){
                System.out.println(f);
            }
        }else {
            System.out.println("null");
        }

        return map;
    }


    @RequestMapping("getChukuList")//系统推荐出库食品列表
    public PageQueryBean getChukuList(HttpSession session){
        String perOrderNum = (String) session.getAttribute("perOrderNum");
        PageQueryBean pageQueryBean = new PageQueryBean();

        //根据预选单号，查询预选单，然后根据每条食品，去查询库存，根据生产日期推荐出库的货架
        List<FoodRemainder> chukuList = outSer.getChukuList(perOrderNum);
        pageQueryBean.setItems(chukuList);
        pageQueryBean.setTotalRows(chukuList.size());
        pageQueryBean.map.put("perOrderNum",perOrderNum);
        return pageQueryBean;
    }

    @RequestMapping("save")//出库操作
    public Map save(String param,HttpSession session){
        Map map = new HashMap<String,Object>();
        try {
            String perOrderNum = (String) session.getAttribute("perOrderNum");//预选单号
            String outNum = outSer.chuku(param,((User)session.getAttribute("sysUser")).getName(),perOrderNum);
            if(outNum != null){
                session.setAttribute("outNum",outNum);
                map.put("state",1);
            }else {
                map.put("state",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",0);
        }
        return map;
    }


    @RequestMapping("getChukuDetail")//根据出库单得到出库明细
    public Map getChukuDetail(HttpSession session){
        String outNum = String.valueOf(session.getAttribute("outNum"));
        Map map = new HashMap<String,Object>();
        List list = outSer.getChukuDeatil(outNum);
        map.put("list",list);
        map.put("size",list.size());
        return map;
    }

    @RequestMapping("getChukuOrderList")//得到出库单列表
    public PageQueryBean getChukuOrderList(){
        PageQueryBean pageQueryBean = new PageQueryBean();
        List<Chuku> list = outSer.getChukuOrderList();
        pageQueryBean.setItems(list);
        pageQueryBean.setTotalRows(list.size());
        return pageQueryBean;

    }

    @RequestMapping("writeOutNum")
    public Map writeOutNum(HttpSession session,String orderNum){
        session.setAttribute("outNum",orderNum);
        return new HashMap();
    }
}
