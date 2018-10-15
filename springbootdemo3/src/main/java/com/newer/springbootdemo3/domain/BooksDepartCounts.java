package com.newer.springbootdemo3.domain;

import java.io.Serializable;
import java.util.List;

public class BooksDepartCounts implements Serializable{
    private String dename;//科室名
    private List<Integer> countList;

    public String getDename() {
        return dename;
    }

    public void setDename(String dename) {
        this.dename = dename;
    }

    public List<Integer> getCountList() {
        return countList;
    }

    public void setCountList(List<Integer> countList) {
        this.countList = countList;
    }
}
