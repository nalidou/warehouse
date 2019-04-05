package com.warems.warehouse.ctl;

import com.warems.warehouse.entity.PageQueryBean;
import com.warems.warehouse.entity.User;
import com.warems.warehouse.service.UserSer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserCtl {
    @Resource
    private UserSer userSer;

    @RequestMapping("getSysUser")
    public Map getSysUser(HttpSession session){
        Map map = new HashMap<String,Object>();
        User user = (User)session.getAttribute("sysUser");

        if(user != null){
            map.put("state",1);
            map.put("sysUser",user);
        }else {
            map.put("state",0);
        }
        return  map;
    }

    @RequestMapping("changePwd")
    public Map changePwd(User user){
        Map map = new HashMap<String,Object>();
        if(userSer.changePwd(user)){
            map.put("state",1);
        }else {
            map.put("state",0);
        }
        return map;
    }

    @RequestMapping("add")
    public Map add(User user){
        Map map = new HashMap<String,Object>();
        if(userSer.add(user)){
            map.put("state",1);
        }else {
            map.put("state",0);
        }
        return map;
    }

    @RequestMapping("getList")
    public PageQueryBean getList(User user){
        PageQueryBean pageQueryBean = new PageQueryBean();
        List<User> list = userSer.getAll(user);
        if(list != null && list.size() > 0){
            pageQueryBean.setTotalRows(list.size());
            pageQueryBean.setItems(list);
        }else {
            pageQueryBean.setItems(null);
            pageQueryBean.setTotalRows(0);
        }

        return pageQueryBean;
    }

    @RequestMapping("delete")
    public Map delete(User user){
        Map map = new HashMap<String,Object>();
        userSer.delete(user);
        return map;
    }
    @RequestMapping("writeModifyId")
    public Map writeModifyId(Integer id, HttpSession session){
        Map map = new HashMap<String,Object>();
        session.setAttribute("modifyId",id);
        return map;
    }

    @RequestMapping("review")
    public Map review(HttpSession session){
        Map map = new HashMap<String,Object>();
        Integer modifyId = (int)session.getAttribute("modifyId");

        User u = userSer.getOne(new User(modifyId));
        if(u != null){
            map.put("user",u);
            map.put("state",1);
        }else {
            map.put("state",0);
        }
        return map;
    }

    @RequestMapping("modify")
    public Map modify(User user){
        Map map = new HashMap<String,Object>();
        if(userSer.update(user)){
            map.put("state",1);
        }else {
            map.put("state",0);
        }
        return map;
    }


}
