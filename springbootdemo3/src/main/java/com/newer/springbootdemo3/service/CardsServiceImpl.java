package com.newer.springbootdemo3.service;


import com.newer.springbootdemo3.domain.Cards;
import com.newer.springbootdemo3.mapper.CardsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class CardsServiceImpl implements CardsService{

    @Autowired
    private CardsMapper cardsMapper;



    @Override
    public List<Cards> findAllc() {
        return cardsMapper.findAllc();
    }
}
