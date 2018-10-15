package com.newer.springbootdemo3.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Admins implements Serializable{

    private Integer aid;
    private String aname;
    private String pwd;
    private Integer state;
    private String email;
    private Integer aexist;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;
    private Integer doid;
    private String by1;
    private Date lastpasswordresetdate;
    //用户所属的角色集合//
    private List<Authority> authorities;

    public Date getLastpasswordresetdate() {
        return lastpasswordresetdate;
    }

    public void setLastpasswordresetdate(Date lastpasswordresetdate) {
        this.lastpasswordresetdate = lastpasswordresetdate;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAexist() {
        return aexist;
    }

    public void setAexist(Integer aexist) {
        this.aexist = aexist;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getDoid() {
        return doid;
    }

    public void setDoid(Integer doid) {
        this.doid = doid;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }
}
