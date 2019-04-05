package com.warems.warehouse.entity;

public class Godownoutdetail
{
    private Integer id;
    private String encode;//编码
    private Integer foodid;//食物ID
    private Integer outnum;//出库数量
    private String PosenCode;//位置编码

    public Godownoutdetail() {
    }

    public Godownoutdetail(Integer id, String encode, Integer foodid, Integer outnum, String posencode) {
        this.id = id;
        this.encode = encode;
        this.foodid = foodid;
        this.outnum = outnum;
        this.PosenCode = posencode;
    }

    public Godownoutdetail(String encode, Integer foodid, Integer outnum, String posencode) {
        this.encode = encode;
        this.foodid = foodid;
        this.outnum = outnum;
        this.PosenCode = posencode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public Integer getOutnum() {
        return outnum;
    }

    public void setOutnum(Integer outnum) {
        this.outnum = outnum;
    }

    public String getPosencode() {
        return PosenCode;
    }

    public void setPosencode(String posencode) {
        this.PosenCode = posencode;
    }

    @Override
    public String toString() {
        return "Godownoutdetail{" +
                "id=" + id +
                ", encode='" + encode + '\'' +
                ", foodid=" + foodid +
                ", outnum=" + outnum +
                ", posencode='" + PosenCode + '\'' +
                '}';
    }
}
