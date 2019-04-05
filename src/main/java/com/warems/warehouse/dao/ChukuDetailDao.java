package com.warems.warehouse.dao;

import com.warems.warehouse.entity.ChukuDetail;

import java.util.List;

public interface ChukuDetailDao {
    public void addOne(ChukuDetail chukuDetail);
    public List<ChukuDetail> getAll(ChukuDetail chukuDetail);


}
