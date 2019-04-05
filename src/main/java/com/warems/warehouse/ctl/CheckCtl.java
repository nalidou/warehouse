package com.warems.warehouse.ctl;

import com.warems.warehouse.entity.*;
import com.warems.warehouse.service.CheckSer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("check")
public class CheckCtl {
    @Resource
    private CheckSer checkSer;

    @RequestMapping("doCheck")
    public Map doCheck(CheckList checkList, HttpSession session){
        Map map = new HashMap<String,Object>();
        User user =  (User) session.getAttribute("sysUser");
        String code = checkSer.doCheck(checkList,user.getName());

        if(code != null){
            map.put("state",1);
        }else {
            map.put("state",0);
        }

        return map;
    }

    @RequestMapping("getCheckList")
    public PageQueryBean getCheckList(){
        PageQueryBean pageQueryBean = new PageQueryBean();
        List<Check> list = checkSer.getCheckList();
        pageQueryBean.setItems(list);
        pageQueryBean.setTotalRows(list.size());
        return pageQueryBean;

    }

    @RequestMapping("getCheckDetail")
    public PageQueryBean getCheckDetail(HttpSession session){
        PageQueryBean pageQueryBean = new PageQueryBean();
        String checkCode = (String) session.getAttribute("checkCode");
        List<CheckDetail2> list = checkSer.getCheckDetail(checkCode);
        //System.out.println(list);
        //System.out.println(list.size());
        pageQueryBean.map.put("code",checkCode);
//

        pageQueryBean.setItems(list);
        pageQueryBean.setTotalRows(list.size());
        return pageQueryBean;

    }

    @RequestMapping("write")
    public Map write(HttpSession session, String code){
        Map map = new HashMap();
        session.setAttribute("checkCode",code);
        return map;
    }

}
