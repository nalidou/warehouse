package com.warems.warehouse.entity;

import java.util.Date;

public class Godownout
{
    private Integer id;
    private String outordernumber;//出库单号
    private String preordernumber;//出库预选单号
    private Date createdate;//创建时间
    private Date outdate;//出库时间
    private String state;//状态（根据状态判断是出库单或是预选单）
    private String agent;//经办人
    private String storeman;//保管员
    private String outencode;//出库详单编码



    @Override
    public String toString() {
        return "Godownout{" +
                "id=" + id +
                ", outordernumber='" + outordernumber + '\'' +
                ", preordernumber='" + preordernumber + '\'' +
                ", createdate=" + createdate +
                ", outdate=" + outdate +
                ", state='" + state + '\'' +
                ", agent='" + agent + '\'' +
                ", storeman='" + storeman + '\'' +
                ", outencode='" + outencode + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOutordernumber() {
        return outordernumber;
    }

    public void setOutordernumber(String outordernumber) {
        this.outordernumber = outordernumber;
    }

    public String getPreordernumber() {
        return preordernumber;
    }

    public void setPreordernumber(String preordernumber) {
        this.preordernumber = preordernumber;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getStoreman() {
        return storeman;
    }

    public void setStoreman(String storeman) {
        this.storeman = storeman;
    }

    public String getOutencode() {
        return outencode;
    }

    public void setOutencode(String outencode) {
        this.outencode = outencode;
    }

    public Godownout(String outordernumber, String preordernumber, Date createdate, Date outdate, String state, String agent, String storeman, String outencode) {
        this.outordernumber = outordernumber;
        this.preordernumber = preordernumber;
        this.createdate = createdate;
        this.outdate = outdate;
        this.state = state;
        this.agent = agent;
        this.storeman = storeman;
        this.outencode = outencode;
    }

    public Godownout(Integer id, String outordernumber, String preordernumber, Date createdate, Date outdate, String state, String agent, String storeman, String outencode) {
        this.id = id;
        this.outordernumber = outordernumber;
        this.preordernumber = preordernumber;
        this.createdate = createdate;
        this.outdate = outdate;
        this.state = state;
        this.agent = agent;
        this.storeman = storeman;
        this.outencode = outencode;
    }




}
