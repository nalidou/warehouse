package com.warems.warehouse.dao;

import com.warems.warehouse.entity.Warehouse;

import java.util.List;

public interface WarehouseDao {
    public void add(Warehouse w);
    public void delete(Warehouse w);
    public void update(Warehouse w);
    public Warehouse getOne(Warehouse w);
    public List<Warehouse> getAll();
    public void updateUsed(Warehouse w);
}
