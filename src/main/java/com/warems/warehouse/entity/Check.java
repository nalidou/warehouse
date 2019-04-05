package com.warems.warehouse.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Check {
    private Integer id; //主键
    private String encode; //盘点详单编码
    private String checkman; //盘点人
    private Date checkdate; //盘点日期
    private String checkdateStr;

    public Check() {
    }

    public Check(Integer id, String encode, String checkman, Date checkdate) {
        this.id = id;
        this.encode = encode;
        this.checkman = checkman;
        this.checkdate = checkdate;
    }

    public Check(String encode, String checkman, Date checkdate) {
        this.encode = encode;
        this.checkman = checkman;
        this.checkdate = checkdate;
    }

    public String getCheckdateStr() {
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(this.getCheckdate());
    }

    public void setCheckdateStr(String checkdateStr) {
        this.checkdateStr = checkdateStr;
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", encode='" + encode + '\'' +
                ", checkman='" + checkman + '\'' +
                ", checkdate=" + checkdate +
                '}';
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

    public String getCheckman() {
        return checkman;
    }

    public void setCheckman(String checkman) {
        this.checkman = checkman;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }
}
