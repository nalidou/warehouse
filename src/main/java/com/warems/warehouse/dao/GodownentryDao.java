package com.warems.warehouse.dao;

import com.warems.warehouse.entity.Godownentry;

import java.util.List;

public interface GodownentryDao {
    /*
    public void add(Godownentry g);
    public void delete(Godownentry g);
    public void update(Godownentry g);
    public Godownentry getOne(Godownentry g);
    public List<Godownentry> getAll();
    */
    public Godownentry getLast();
    public List<Godownentry> getAll(Godownentry g);

}
