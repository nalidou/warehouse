package com.warems.warehouse.dao;

import com.warems.warehouse.entity.Check;
import com.warems.warehouse.entity.CheckList;

import java.util.List;

public interface CheckDao {

    public void delete(Check c);
    public void update(Check c);
    public Check getOne(Check c);


    public void add(Check c);
    public List<Check> getAll();
    public Check getLast();


    //根据品名、规格、货架进行盘点
    public List<CheckList> getCheckList(CheckList checkList);


}
