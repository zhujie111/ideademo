package com.newer.springbootdemo3.domain;

import java.io.Serializable;

public class Departs implements Serializable{

    private Integer deid;
    private String dename;
    private String intro;
    private Integer deexist;
    private String by1;
    private String by2;

    public Integer getDeid() {
        return deid;
    }

    public void setDeid(Integer deid) {
        this.deid = deid;
    }

    public String getDename() {
        return dename;
    }

    public void setDename(String dename) {
        this.dename = dename;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getDeexist() {
        return deexist;
    }

    public void setDeexist(Integer deexist) {
        this.deexist = deexist;
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
