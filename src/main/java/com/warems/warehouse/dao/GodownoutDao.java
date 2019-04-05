package com.warems.warehouse.dao;

import com.warems.warehouse.entity.Godownout;
import java.util.List;

public interface GodownoutDao
{
    public void add(Godownout g);
    public void delete(Godownout g);
    public void update(Godownout g);
    public Godownout getOne(Godownout g);
    public List<Godownout> getAll(Godownout g);
    public void updateUsed(Godownout g);

}
