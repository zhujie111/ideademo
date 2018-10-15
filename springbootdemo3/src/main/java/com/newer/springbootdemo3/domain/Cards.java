package com.newer.springbootdemo3.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Cards implements Serializable{
    private Integer cid;
    private String pname;
    private String gender;
    private String phone;
    private String idcard;
    private String pwd;
    private Double ramaining;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd ")
    private Date newdate;
    private Integer doexist;
    private String by1;
    private String by2;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Double getRamaining() {
        return ramaining;
    }

    public void setRamaining(Double ramaining) {
        this.ramaining = ramaining;
    }

    public Date getNewdate() {
        return newdate;
    }

    public void setNewdate(Date newdate) {
        this.newdate = newdate;
    }

    public Integer getDoexist() {
        return doexist;
    }

    public void setDoexist(Integer doexist) {
        this.doexist = doexist;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public String getBy2() {
        return by2;
    }

    public void setBy2(String by2) {
        this.by2 = by2;
    }
}
