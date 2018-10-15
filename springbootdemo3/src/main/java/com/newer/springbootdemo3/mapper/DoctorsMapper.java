package com.newer.springbootdemo3.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author shining
 */
@CacheNamespace(implementation = com.newer.springbootdemo3.util.RedisCache.class)
public interface DoctorsMapper {

    @Select("select title from doctors where doid=#{doid}")
    String findTitle(@Param("doid")Integer doid);
}
