package com.newer.springbootdemo3.service;

import com.newer.springbootdemo3.domain.Departs;
import com.newer.springbootdemo3.mapper.DepartsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("departsService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class DepartsServiceImpl implements DepartsService{

    @Autowired
    private DepartsMapper departsMapper;

    @Override
    public List<Departs> findAll1() {
        return departsMapper.findAll1();
    }


    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int updateDeexist(Integer deid) {
        return departsMapper.updateDeexist(deid);
    }

    @Override
    public List<Departs> findAll2() {
        return departsMapper.findAll2();
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int changeDeexist(Integer deid) {
        return departsMapper.changeDeexist(deid);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int addDeparts(Departs departs) {
        int result=departsMapper.addDeparts(departs);

        return result;
    }


    @Override
    public List<Departs> findById(Integer deid) {
        return departsMapper.findById(deid);
    }


    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int usDeparts(Integer deid) {
        return departsMapper.usDeparts(deid);
    }
}
