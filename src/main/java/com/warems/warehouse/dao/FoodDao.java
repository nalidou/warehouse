package com.warems.warehouse.dao;

import com.warems.warehouse.entity.Food;

import java.util.List;
import java.util.Map;

public interface FoodDao {
    public void add(Food f);
    public void delete(Food f);
    public void update(Food f);
    public Food getOne(Food f);
    public List<Food> getAll();

    public Integer entryByProcedure(Map<String,Object> map);

}
