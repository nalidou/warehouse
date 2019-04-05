package com.warems.warehouse.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Chuku {
    private Integer id;
    private String out_num;
    private Date createdate;
    private String createdateStr;
    private String agent;

    public Chuku() {

    }

    public String getCreatedateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.getCreatedate());
    }

    public void setCreatedateStr(String createdateStr) {
        this.createdateStr = createdateStr;
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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    @Override
    public String toString() {
        return "Chuku{" +
                "id=" + id +
                ", out_num='" + out_num + '\'' +
                ", createdate=" + createdate +
                ", agent='" + agent + '\'' +
                '}';
    }
}
