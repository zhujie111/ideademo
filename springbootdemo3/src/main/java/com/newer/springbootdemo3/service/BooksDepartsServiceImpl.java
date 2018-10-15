package com.newer.springbootdemo3.service;

import com.newer.springbootdemo3.mapper.BookDepartsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("booksDepartService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class BooksDepartsServiceImpl implements BooksDepartService{

    @Autowired
    private BookDepartsMapper bookDepartsMapper;

    @Override
    public int getToday(Integer deid) {
        return bookDepartsMapper.getToday(deid);
    }

    @Override
    public int getYestoday(Integer deid) {
        return bookDepartsMapper.getYestoday(deid);
    }

    @Override
    public int getWeek(Integer deid) {
        return bookDepartsMapper.getWeek(deid);
    }

    @Override
    public int getMonth(Integer deid) {
        return bookDepartsMapper.getMonth(deid);
    }

    @Override
    public int getQuarter(Integer deid) {
        return bookDepartsMapper.getQuarter(deid);
    }
}
