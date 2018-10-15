package com.newer.springbootdemo3.security.service;

import com.newer.springbootdemo3.domain.Admins;
import com.newer.springbootdemo3.mapper.AdminsMapper;
import com.newer.springbootdemo3.mapper.DoctorsMapper;
import com.newer.springbootdemo3.security.domain.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shining
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class JwtUserDetailsService implements UserDetailsService{

    @Autowired
    private AdminsMapper adminsMapper;
    @Autowired
    private DoctorsMapper doctorsMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admins admins=adminsMapper.findByUsername(username);
        if(admins==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //处理医生头衔
        if(admins.getState()==2){
            admins.setBy1(doctorsMapper.findTitle(admins.getDoid()));
        }
        return JwtUserFactory.create(admins);
    }
}
