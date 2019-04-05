package com.warems.warehouse.dao;

import com.warems.warehouse.entity.YuXuanDetail;

import java.util.List;

public interface YuXuanDetailDao {
    public void addOne(YuXuanDetail yuXuanDetail);
    public List<YuXuanDetail> getAll(YuXuanDetail yuXuanDetail);
}
