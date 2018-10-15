package com.newer.springbootdemo3;

import com.newer.springbootdemo3.domain.Admins;
import com.newer.springbootdemo3.mapper.AdminsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminsTest {

    @Autowired
    private AdminsMapper adminsMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testLogin(){
        Admins admins=adminsMapper.findByParam("admin","111222");
        System.out.println(admins.getLoginTime());
    }

    @Test
    public void testLoadByUsername(){
        Admins admins=adminsMapper.findByUsername("admin");
        System.out.println(admins.getLoginTime());

    }

    @Test
    public void testpassword(){
        String str=passwordEncoder.encode("admin");
        System.out.println(str);
    }

}
