package com.newer.springbootdemo3;

import com.newer.springbootdemo3.domain.Admins;
import com.newer.springbootdemo3.domain.Departs;
import com.newer.springbootdemo3.mapper.AdminsMapper;
import com.newer.springbootdemo3.mapper.DepartsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {
    @Autowired
    private DepartsMapper departsMapper;

    @Autowired
    private AdminsMapper adminsMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test(){
        List<Departs> list1=departsMapper.findAll1();
        System.out.println("第一次查询:"+list1.size());
        List<Departs> list2=departsMapper.findAll1();
        System.out.println("第二次查询:"+list2.size());
        List<Departs> list3=departsMapper.findAll1();
        System.out.println("第三次查询:"+list3.size());
    }

    @Test
    public void test1(){
//        Admins admins1=adminsMapper.findByUsername("admin");
//        System.out.println("第一次查询:"+admins1.getPwd());
//        adminsMapper.updatePwd(admins1.getAid(),passwordEncoder.encode("admin"));
//        Admins admins2=adminsMapper.findByUsername("admin");
//        System.out.println("第二次查询:"+admins2.getPwd());

        List<Admins> list1=adminsMapper.findByState(1);
        System.out.println("第一次查询:"+list1.size());
        List<Admins> list2=adminsMapper.findByState(1);
        System.out.println("第二次查询:"+list2.size());
    }
}
