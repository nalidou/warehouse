package com.warems.warehouse.dao;

import com.warems.warehouse.entity.Role;

import java.util.List;

public interface RoleDao
{
    public void add(Role r);
    public void delete(Role r);
    public void update(Role r);
    public Role getOne(Role r);
    public List<Role> getAll(Role r);
}
