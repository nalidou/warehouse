package com.warems.warehouse.entity;

import java.util.Date;

public class YuXuanDetail {

    private Integer yxd_id;
    private String yxd_preorder_number;
    private String yxd_foodname;
    private String yxd_foodstandard;
    private Integer yxd_num;

    public YuXuanDetail() {
    }

    public Integer getYxd_num() {
        return yxd_num;
    }

    public void setYxd_num(Integer yxd_num) {
        this.yxd_num = yxd_num;
    }

    public Integer getYxd_id() {
        return yxd_id;
    }

    public void setYxd_id(Integer yxd_id) {
        this.yxd_id = yxd_id;
    }

    public String getYxd_preorder_number() {
        return yxd_preorder_number;
    }

    public void setYxd_preorder_number(String yxd_preorder_number) {
        this.yxd_preorder_number = yxd_preorder_number;
    }

    public String getYxd_foodname() {
        return yxd_foodname;
    }

    public void setYxd_foodname(String yxd_foodname) {
        this.yxd_foodname = yxd_foodname;
    }

    public String getYxd_foodstandard() {
        return yxd_foodstandard;
    }

    public void setYxd_foodstandard(String yxd_foodstandard) {
        this.yxd_foodstandard = yxd_foodstandard;
    }

    @Override
    public String toString() {
        return "YuXuanDetail{" +
                "yxd_id=" + yxd_id +
                ", yxd_preorder_number='" + yxd_preorder_number + '\'' +
                ", yxd_foodname='" + yxd_foodname + '\'' +
                ", yxd_foodstandard='" + yxd_foodstandard + '\'' +
                ", yxd_num=" + yxd_num +
                '}';
    }
}
