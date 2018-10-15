package com.newer.springbootdemo3.domain;

import java.io.Serializable;
import java.util.List;

public class BooksDepart implements Serializable{

    private List<String> times;//时间段名称的集合
    private List<BooksDepartCounts> booksDepartCounts;//所有科室对应时间段挂号

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    public List<BooksDepartCounts> getBooksDepartCounts() {
        return booksDepartCounts;
    }

    public void setBooksDepartCounts(List<BooksDepartCounts> booksDepartCounts) {
        this.booksDepartCounts = booksDepartCounts;
    }
}
