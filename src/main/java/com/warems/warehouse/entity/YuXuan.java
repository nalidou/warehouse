package com.warems.warehouse.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class YuXuan {

    private Integer yx_id;
    private String yx_preorder_number;
    private Date yx_createdate;
    private String yx_createdateStr;

    private String yx_agent;
    private Integer state;

    private String start;
    private String end;

    public YuXuan() {
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getYx_createdateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.getYx_createdate());
    }

    public void setYx_createdateStr(String yx_createdateStr) {
        this.yx_createdateStr = yx_createdateStr;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getYx_id() {
        return yx_id;
    }

    public void setYx_id(Integer yx_id) {
        this.yx_id = yx_id;
    }

    public String getYx_preorder_number() {
        return yx_preorder_number;
    }

    public void setYx_preorder_number(String yx_preorder_number) {
        this.yx_preorder_number = yx_preorder_number;
    }

    public Date getYx_createdate() {
        return yx_createdate;
    }

    public void setYx_createdate(Date yx_createdate) {
        this.yx_createdate = yx_createdate;
    }

    public String getYx_agent() {
        return yx_agent;
    }

    public void setYx_agent(String yx_agent) {
        this.yx_agent = yx_agent;
    }

    @Override
    public String toString() {
        return "YuXuan{" +
                "yx_id=" + yx_id +
                ", yx_preorder_number='" + yx_preorder_number + '\'' +
                ", yx_createdate=" + yx_createdate +
                ", yx_agent='" + yx_agent + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
