package com.newer.springbootdemo3.security.domain;

import com.newer.springbootdemo3.domain.Admins;
import com.newer.springbootdemo3.domain.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    private JwtUserFactory(){}

    public static JwtUser create(Admins admins){
       return new JwtUser(
               admins.getAid(),
               admins.getAname(),
               admins.getPwd(),
               admins.getAexist()==1?true:false,
               admins.getState(),
               admins.getEmail(),
               admins.getLoginTime(),
               admins.getDoid(),
               admins.getBy1(),
               admins.getLastpasswordresetdate(),
               mapToGrantedAuthority(admins.getAuthorities())
       );
    }

    private static Collection<? extends GrantedAuthority> mapToGrantedAuthority(List<Authority> list){
        //遍历list，将每个角色变成SimpleGrantedAuthority类型
        //再封装成集合返回
        return list.stream().map(authority -> new SimpleGrantedAuthority(authority.getName().name())).collect(Collectors.toList());
    }
}
