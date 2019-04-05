package com.warems.warehouse.dao;

import com.warems.warehouse.entity.Chuku;

import java.util.List;

public interface ChukuDao {

    public Chuku getLast();
    public void addOne(Chuku chuku);
    public List<Chuku> getAll(Chuku chuku);
}
