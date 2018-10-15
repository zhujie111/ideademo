package com.newer.springbootdemo3.mapper;

import com.newer.springbootdemo3.domain.Admins;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author shining
 */
@CacheNamespace(implementation = com.newer.springbootdemo3.util.RedisCache.class)
public interface AdminsMapper {

    //登录
    @Select("select * from admins where aname=#{aname} and pwd=#{pwd} ")
    Admins findByParam(@Param("aname")String aname,
                       @Param("pwd")String pwd);

    //根据id修改最后一次登录时间
    @Update("update admins set login_time=now() where aid=#{aid}")
    int updateLoginTime(@Param("aid")Integer aid);

    //根据id更新最后一次修改密码时间
    @Update("update admins set lastpasswordresetdate=curdate() where aid=#{aid}")
    int updatePwdTime(@Param("aid")Integer aid);

    //根据id更新密码
    @Update("update admins set pwd=#{pwd} where aid=#{aid}")
    int updatePwd(@Param("aid")Integer aid,@Param("pwd")String pwd);

    Admins findByUsername(@Param("username")String username);

    @Select("select aid,aname,aexist,by1 from admins where state=#{state}")
    //@Options(useCache = false)不使用二级缓存
    List<Admins> findByState(@Param("state")Integer state);

    //添加用户
    @Insert("insert into admins (aname,pwd,state,aexist,by1) values(#{aname},#{pwd},#{state},1,#{by1})")
    int addAdmins(Admins admins);

    //根据添加用户添加人数
    @Insert("insert into user_authority values(@@identity,#{authorityId})")
    int addAuthority(@Param("authorityId") int authorityId);

    //停用用户
    @Update("update admins set aexist=0 where aid=#{aid}")
    int changeAexist(@Param("aid")Integer aid);

    //启用用户
    @Update("update admins set aexist=1 where aid=#{aid}")
    int updateAexist(@Param("aid")Integer aid);
}
