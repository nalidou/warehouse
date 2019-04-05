package com.warems.warehouse.entity;

public class Checkdetail {
    private Integer id; //主键
    private String encode; //编码
    private Integer foodid; //食物id
    private Integer entrynum; //入库数量
    private Integer outnum; //出库数量
    private Integer rem_number; //剩余数量
    private String entrydate; //入库时间
    private String posencode; //位置编码
    private String entryman; //录入人

    @Override
    public String toString() {
        return "Checkdetail{" +
                "id=" + id +
                ", encode='" + encode + '\'' +
                ", foodid=" + foodid +
                ", entrynum=" + entrynum +
                ", outnum=" + outnum +
                ", rem_number=" + rem_number +
                ", entrydate='" + entrydate + '\'' +
                ", posencode='" + posencode + '\'' +
                ", entryman='" + entryman + '\'' +
                '}';
    }

    public Checkdetail() {
    }

    public Checkdetail(String encode, Integer foodid, Integer entrynum, Integer outnum, Integer rem_number, String entrydate, String posencode, String entryman) {
        this.encode = encode;
        this.foodid = foodid;
        this.entrynum = entrynum;
        this.outnum = outnum;
        this.rem_number = rem_number;
        this.entrydate = entrydate;
        this.posencode = posencode;
        this.entryman = entryman;
    }

    public Checkdetail(Integer id, String encode, Integer foodid, Integer entrynum, Integer outnum, Integer rem_number, String entrydate, String posencode, String entryman) {
        this.id = id;
        this.encode = encode;
        this.foodid = foodid;
        this.entrynum = entrynum;
        this.outnum = outnum;
        this.rem_number = rem_number;
        this.entrydate = entrydate;
        this.posencode = posencode;
        this.entryman = entryman;
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

    public Integer getEntrynum() {
        return entrynum;
    }

    public void setEntrynum(Integer entrynum) {
        this.entrynum = entrynum;
    }

    public Integer getOutnum() {
        return outnum;
    }

    public void setOutnum(Integer outnum) {
        this.outnum = outnum;
    }

    public Integer getRem_number() {
        return rem_number;
    }

    public void setRem_number(Integer rem_number) {
        this.rem_number = rem_number;
    }

    public String getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(String entrydate) {
        this.entrydate = entrydate;
    }

    public String getPosencode() {
        return posencode;
    }

    public void setPosencode(String posencode) {
        this.posencode = posencode;
    }

    public String getEntryman() {
        return entryman;
    }

    public void setEntryman(String entryman) {
        this.entryman = entryman;
    }
}
