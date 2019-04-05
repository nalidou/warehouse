package com.warems.warehouse.entity;

import java.util.Date;

public class Out {
    private Integer cid;
    private String cencode;
    private Integer cfoodid;
    private Integer centrynum;
    private Integer coutnum;
    private Integer cremnumber;
    private String centrydate;
    private String cposencode;
    private String centryman;

    @Override
    public String toString() {
        return "Out{" +
                "cid=" + cid +
                ", cencode='" + cencode + '\'' +
                ", cfoodid=" + cfoodid +
                ", centrynum=" + centrynum +
                ", coutnum=" + coutnum +
                ", cremnumber=" + cremnumber +
                ", centrydate='" + centrydate + '\'' +
                ", cposencode='" + cposencode + '\'' +
                ", centryman='" + centryman + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCencode() {
        return cencode;
    }

    public void setCencode(String cencode) {
        this.cencode = cencode;
    }

    public Integer getCfoodid() {
        return cfoodid;
    }

    public void setCfoodid(Integer cfoodid) {
        this.cfoodid = cfoodid;
    }

    public Integer getCentrynum() {
        return centrynum;
    }

    public void setCentrynum(Integer centrynum) {
        this.centrynum = centrynum;
    }

    public Integer getCoutnum() {
        return coutnum;
    }

    public void setCoutnum(Integer coutnum) {
        this.coutnum = coutnum;
    }

    public Integer getCremnumber() {
        return cremnumber;
    }

    public void setCremnumber(Integer cremnumber) {
        this.cremnumber = cremnumber;
    }

    public String getCentrydate() {
        return centrydate;
    }

    public void setCentrydate(String centrydate) {
        this.centrydate = centrydate;
    }

    public String getCposencode() {
        return cposencode;
    }

    public void setCposencode(String cposencode) {
        this.cposencode = cposencode;
    }

    public String getCentryman() {
        return centryman;
    }

    public void setCentryman(String centryman) {
        this.centryman = centryman;
    }

    public Out() {
    }

    public Out(Integer cid, String cencode, Integer cfoodid, Integer centrynum, Integer coutnum, Integer cremnumber, String centrydate, String cposencode, String centryman) {
        this.cid = cid;
        this.cencode = cencode;
        this.cfoodid = cfoodid;
        this.centrynum = centrynum;
        this.coutnum = coutnum;
        this.cremnumber = cremnumber;
        this.centrydate = centrydate;
        this.cposencode = cposencode;
        this.centryman = centryman;
    }
}
