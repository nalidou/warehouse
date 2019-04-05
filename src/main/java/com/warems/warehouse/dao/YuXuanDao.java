package com.warems.warehouse.dao;

import com.warems.warehouse.entity.YuXuan;

import java.util.List;

public interface YuXuanDao {
    public void addOne(YuXuan yuXuan);
    public List<YuXuan> getAll(YuXuan yuXuan);
    public YuXuan getLast();

    public YuXuan getOne(YuXuan yuXuan);
    public void updateState(YuXuan yuXuan);
}
