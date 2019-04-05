package com.warems.warehouse.entity;

public class Warehouse {
    private Integer id; //主键
    private String name; //名称
    private Integer shelfnum; //货架数量

    public Warehouse(Integer id, String name, Integer shelfnum) {
        this.id = id;
        this.name = name;
        this.shelfnum = shelfnum;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shelfnum=" + shelfnum +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShelfnum() {
        return shelfnum;
    }

    public void setShelfnum(Integer shelfnum) {
        this.shelfnum = shelfnum;
    }
}
