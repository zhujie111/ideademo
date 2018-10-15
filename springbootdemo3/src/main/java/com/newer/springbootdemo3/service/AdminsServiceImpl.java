package com.newer.springbootdemo3.service;

import com.newer.springbootdemo3.domain.Admins;
import com.newer.springbootdemo3.mapper.AdminsMapper;
import com.newer.springbootdemo3.mapper.DoctorsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shining
 */
@Service("adminsService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class AdminsServiceImpl implements AdminsService {
    @Autowired
    private AdminsMapper adminsMapper;
    @Autowired
    private DoctorsMapper doctorsMapper;

    @Deprecated
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public Admins login(String aname, String pwd) {
        Admins admins=adminsMapper.findByParam(aname,pwd);
        if(admins!=null){
            adminsMapper.updateLoginTime(admins.getAid());
            if(admins.getState()==2){
                admins.setBy1(doctorsMapper.findTitle(admins.getDoid()));
            }
        }
        return admins;
    }


    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int updatePwd(Integer aid, String pwd) {
        int result=adminsMapper.updatePwd(aid,pwd);
        if(result>0){
            adminsMapper.updatePwdTime(aid);
        }
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int updateLoginTime(Integer aid) {
        return adminsMapper.updateLoginTime(aid);
    }

    @Override
    public List<Admins> findByState(Integer state) {
        return adminsMapper.findByState(state);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int addAdmins(Admins admins) {
        int result=adminsMapper.addAdmins(admins);
        if(result>0) {
            adminsMapper.addAuthority(admins.getState());
        }
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int changeAexist(Integer aid) {
        return adminsMapper.changeAexist(aid);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int updateAexist(Integer aid) {
        return adminsMapper.updateAexist(aid);
    }
}
