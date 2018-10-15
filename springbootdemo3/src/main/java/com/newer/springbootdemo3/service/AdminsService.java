package com.newer.springbootdemo3.service;

import com.newer.springbootdemo3.domain.Admins;


import java.util.List;

/**
 * @author shining
 */
public interface AdminsService {

    Admins login(String aname,String pwd);

    int updatePwd(Integer aid,String pwd);

    int updateLoginTime(Integer aid);

    List<Admins> findByState(Integer state);

    int addAdmins(Admins admins);

    int changeAexist(Integer aid);

    int updateAexist(Integer aid);

}
