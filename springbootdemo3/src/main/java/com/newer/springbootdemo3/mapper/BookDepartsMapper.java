package com.newer.springbootdemo3.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@CacheNamespace(implementation = com.newer.springbootdemo3.util.RedisCache.class)
public interface BookDepartsMapper {

    @Select("SELECT count(rid) from registration r JOIN bookable b " +
            "ON r.bid=b.bid JOIN doctors d ON b.doid=d.doid " +
            "JOIN departs de ON de.deid=d.deid " +
            "WHERE de.deid=#{deid} AND to_days(bdate)=to_days(now())")
    int getToday(@Param("deid")Integer deid);


    @Select("SELECT count(rid) from registration r JOIN bookable b " +
            "ON r.bid=b.bid JOIN doctors d ON b.doid=d.doid " +
            "JOIN departs de ON de.deid=d.deid " +
            "WHERE de.deid=#{deid} AND to_days(bdate)-to_days(now())=1")
    int getYestoday(@Param("deid")Integer deid);

    @Select("SELECT count(rid) from registration r JOIN bookable b " +
            "ON r.bid=b.bid JOIN doctors d ON b.doid=d.doid " +
            "JOIN departs de ON de.deid=d.deid " +
            "WHERE de.deid=#{deid} AND yearweek(now())=yearweek(bdate)")
    int getWeek(@Param("deid")Integer deid);

    @Select("SELECT count(rid) from registration r JOIN bookable b " +
            "ON r.bid=b.bid JOIN doctors d ON b.doid=d.doid " +
            "JOIN departs de ON de.deid=d.deid " +
            "WHERE de.deid=#{deid} AND date_format(now(),'%Y%m')=date_format(bdate,'%Y%m')")
    int getMonth(@Param("deid")Integer deid);

    @Select("SELECT count(rid) from registration r JOIN bookable b " +
            "ON r.bid=b.bid JOIN doctors d ON b.doid=d.doid " +
            "JOIN departs de ON de.deid=d.deid " +
            "WHERE de.deid=#{deid} AND quarter(now())=quarter(bdate)")
    int getQuarter(@Param("deid")Integer deid);
}
