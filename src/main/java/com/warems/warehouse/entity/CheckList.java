package com.warems.warehouse.entity;

import java.util.Date;

public class CheckList {
    private Integer id;
    private String ck_num;
    private String name;
    private String standard;
    private String unit;
    private String ennumber;
    private String outnumber;
    private String renumber;
    private String price;
    private String producedate;
    private String posencode;
    private Date create_time;
    private String ckman;

    public CheckList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCk_num() {
        return ck_num;
    }

    public void setCk_num(String ck_num) {
        this.ck_num = ck_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getEnnumber() {
        return ennumber;
    }

    public void setEnnumber(String ennumber) {
        this.ennumber = ennumber;
    }

    public String getOutnumber() {
        return outnumber;
    }

    public void setOutnumber(String outnumber) {
        this.outnumber = outnumber;
    }

    public String getRenumber() {
        return renumber;
    }

    public void setRenumber(String renumber) {
        this.renumber = renumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProducedate() {
        return producedate;
    }

    public void setProducedate(String producedate) {
        this.producedate = producedate;
    }

    public String getPosencode() {
        return posencode;
    }

    public void setPosencode(String posencode) {
        this.posencode = posencode;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCkman() {
        return ckman;
    }

    public void setCkman(String ckman) {
        this.ckman = ckman;
    }

    @Override
    public String toString() {
        return "CheckList{" +
                "id=" + id +
                ", ck_num='" + ck_num + '\'' +
                ", name='" + name + '\'' +
                ", standard='" + standard + '\'' +
                ", unit='" + unit + '\'' +
                ", ennumber='" + ennumber + '\'' +
                ", outnumber='" + outnumber + '\'' +
                ", renumber='" + renumber + '\'' +
                ", price='" + price + '\'' +
                ", producedate='" + producedate + '\'' +
                ", posencode='" + posencode + '\'' +
                ", create_time=" + create_time +
                ", ckman='" + ckman + '\'' +
                '}';
    }
}
