package com.warems.warehouse.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChukuDetail {
    private Integer id;
    private String out_num;
    private String food_id;
    private String food_name;
    private String food_standard;
    private String food_unit;
    private String food_num;
    private String food_price;
    private String food_total;
    private Date food_time;
    private String food_time_str;

    private String food_poscode;
    private String outman;

    public ChukuDetail() {
    }

    public String getFood_time_str() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.getFood_time());
    }

    public void setFood_time_str(String food_time_str) {
        this.food_time_str = food_time_str;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOut_num() {
        return out_num;
    }

    public void setOut_num(String out_num) {
        this.out_num = out_num;
    }

    public String getFood_id() {
        return food_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_standard() {
        return food_standard;
    }

    public void setFood_standard(String food_standard) {
        this.food_standard = food_standard;
    }

    public String getFood_unit() {
        return food_unit;
    }

    public void setFood_unit(String food_unit) {
        this.food_unit = food_unit;
    }

    public String getFood_num() {
        return food_num;
    }

    public void setFood_num(String food_num) {
        this.food_num = food_num;
    }

    public String getFood_price() {
        return food_price;
    }

    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }

    public String getFood_total() {
        return food_total;
    }

    public void setFood_total(String food_total) {
        this.food_total = food_total;
    }

    public Date getFood_time() {
        return food_time;
    }

    public void setFood_time(Date food_time) {
        this.food_time = food_time;
    }

    public String getFood_poscode() {
        return food_poscode;
    }

    public void setFood_poscode(String food_poscode) {
        this.food_poscode = food_poscode;
    }

    public String getOutman() {
        return outman;
    }

    public void setOutman(String outman) {
        this.outman = outman;
    }

    @Override
    public String toString() {
        return "ChukuDetail{" +
                "id=" + id +
                ", out_num='" + out_num + '\'' +
                ", food_id='" + food_id + '\'' +
                ", food_name='" + food_name + '\'' +
                ", food_standard='" + food_standard + '\'' +
                ", food_unit='" + food_unit + '\'' +
                ", food_num='" + food_num + '\'' +
                ", food_price='" + food_price + '\'' +
                ", food_total='" + food_total + '\'' +
                ", food_time=" + food_time +
                ", food_poscode='" + food_poscode + '\'' +
                ", outman='" + outman + '\'' +
                '}';
    }
}
