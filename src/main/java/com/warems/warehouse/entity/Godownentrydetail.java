package com.warems.warehouse.entity;

public class Godownentrydetail
{
    private Integer id;
    private String encod;//编码，用于与食品表相连
    private Integer foodid;//食物ID
    private Integer number;//入库数量
    private String posencode;//位置编码

    @Override
    public String toString() {
        return "Godownentrydetail{" +
                "id=" + id +
                ", encod='" + encod + '\'' +
                ", foodid=" + foodid +
                ", number=" + number +
                ", posencode='" + posencode + '\'' +
                '}';
    }



    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setPosencode(String posencode) {
        this.posencode = posencode;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getEncod() {
        return encod;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public Integer getNumber() {
        return number;
    }

    public String getPosencode() {
        return posencode;
    }

    public Godownentrydetail(Integer id, String encod, Integer foodid, Integer number, String posencode) {
        this.id = id;
        this.encod = encod;
        this.foodid = foodid;
        this.number = number;
        this.posencode = posencode;
    }

    public Godownentrydetail() {
    }
}
