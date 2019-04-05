package com.warems.warehouse.dao;

import com.warems.warehouse.entity.Check;
import com.warems.warehouse.entity.FoodRemainder;
import com.warems.warehouse.entity.Out;

import java.util.List;

public interface OutDao {
    public void update(Out o);
    public Out getOne(Out o);
    public List<Out> getAll();
}
