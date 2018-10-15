package com.newer.springbootdemo3.mapper;

import com.newer.springbootdemo3.domain.Departs;
import org.apache.ibatis.annotations.*;

import java.util.List;

@CacheNamespace(implementation = com.newer.springbootdemo3.util.RedisCache.class)
public interface DepartsMapper {

    //查询所有已启用科室信息
    @Select("select * from departs where deexist=1")
    List<Departs> findAll1();


    //查询所有科室信息
    @Select("select deid,dename,intro,deexist from departs")
    List<Departs> findAll2();

    //查询单个科室信息
    @Select("select deid,dename,intro,deexist from departs where deid=#{deid}")
    List<Departs> findById(@Param("deid") Integer deid);

    //修改单个科室信息
    @Update("update departs set dename=#{dename},intro=#{intro},deexist=#{deexist} where deid=#{deid}")
    int usDeparts(@Param("deid")Integer deid);

    //停用科室
    @Update("update departs set deexist=0 where deid=#{deid}")
    int updateDeexist(@Param("deid")Integer deid);

    //启动科室
    @Update("update departs set deexist=1 where deid=#{deid}")
    int changeDeexist(@Param("deid")Integer deid);


    //添加科室
    @Insert("insert into departs (deid, dename, intro, deexist) values (null,#{dename},#{intro},#{deexist})")
    int addDeparts(Departs departs);
}
