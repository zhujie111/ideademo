package com.newer.springbootdemo3.service;

public interface BooksDepartService {

    int getToday(Integer deid);

    int getYestoday(Integer deid);

    int getWeek(Integer deid);

    int getMonth(Integer deid);

    int getQuarter(Integer deid);


}
