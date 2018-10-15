package com.newer.springbootdemo3.service;

import com.newer.springbootdemo3.domain.Departs;

import java.util.List;

public interface DepartsService {

    List<Departs> findAll1();

    List<Departs> findAll2();

    int updateDeexist(Integer deid);

    int changeDeexist(Integer deid);

    int addDeparts(Departs departs);

    List<Departs> findById(Integer deid);

    int usDeparts(Integer deid);
}
