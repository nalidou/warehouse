package com.warems.warehouse.dao;

import com.warems.warehouse.entity.Godownentrydetail;
import java.util.List;



public interface GodownentrydetailDao
{
    public void add(Godownentrydetail g);
    public void delete(Godownentrydetail g);
    public void update(Godownentrydetail g);
    public Godownentrydetail getOne(Godownentrydetail g);
    public List<Godownentrydetail> getAll(Godownentrydetail g);
    public void updateUsed(Godownentrydetail g);
}
