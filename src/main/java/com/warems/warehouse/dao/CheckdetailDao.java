package com.warems.warehouse.dao;

import com.warems.warehouse.entity.Checkdetail;

import java.util.List;

public interface CheckdetailDao {
    public void add(Checkdetail cd);
    public void delete(Checkdetail cd);
    public void update(Checkdetail cd);
    public Checkdetail getOne(Checkdetail cd);
    public List<Checkdetail> getAll();

}
