package com.newer.springbootdemo3.mapper;

import com.newer.springbootdemo3.domain.Cards;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@CacheNamespace(implementation = com.newer.springbootdemo3.util.RedisCache.class)
public interface CardsMapper {

    //查询所有诊疗卡
    @Select("select * from cards")
    List<Cards> findAllc();

}
