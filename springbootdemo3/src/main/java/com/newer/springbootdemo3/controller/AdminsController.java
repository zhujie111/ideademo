package com.newer.springbootdemo3.controller;

import com.newer.springbootdemo3.domain.Admins;
import com.newer.springbootdemo3.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shining
 */
@RestController
@RequestMapping("/admins")
//@CrossOrigin(origins = "http://localhost:8080",maxAge = 3600)
public class AdminsController {
    @Autowired
    private AdminsService adminsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Deprecated
    @RequestMapping("/login")
    public ResponseEntity<?> login(@RequestParam("aname")String aname,
                                   @RequestParam("pwd")String pwd, HttpSession session){
        Admins admins=adminsService.login(aname, pwd);
        if(admins==null){
            return new ResponseEntity<>(new CustomerErrorType("用户名或密码错误！"),HttpStatus.OK);
        }else if(admins.getAexist()!=1){
            return new ResponseEntity<>(new CustomerErrorType("该账户已被禁用"),HttpStatus.OK);
        }else{
            session.setAttribute("loginer",admins);
            return new ResponseEntity<>(admins, HttpStatus.OK);
        }
    }

    @Deprecated
    @RequestMapping(value = "/changepwd",method = RequestMethod.PUT)
    public ResponseEntity<?> changePwd(@RequestParam("pwd")String pwd,
                                       @RequestParam("password")String password,
                                       HttpSession session){
        Admins admins=(Admins)session.getAttribute("loginer");
        if(admins.getPwd().equals(pwd)){
            if(adminsService.updatePwd(admins.getAid(),password)>0){
                admins.setPwd(password);
                session.setAttribute("loginer",admins);
                return new ResponseEntity<>(admins,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new CustomerErrorType("密码修改失败！"),HttpStatus.OK);
            }
        }else{
            return new ResponseEntity<>(new CustomerErrorType("原始密码错误！"),HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{state}",method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findState(@PathVariable("state")Integer state){
        List<Admins> admins=adminsService.findByState(state);

        return new ResponseEntity<>(admins,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addAdmins(@RequestBody Admins admins){

        admins.setPwd(passwordEncoder.encode(admins.getPwd()));
        int result=adminsService.addAdmins(admins);

        Map<String,Object> map=new HashMap<>();

        map.put("result",result);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

    @RequestMapping(value = "/adminschangestate",method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> changeAexist(@RequestParam Integer aid){
        int id=adminsService.changeAexist(aid);

        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @RequestMapping(value = "/adminsupdatestate",method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateAexist(@RequestParam Integer aid){
        int id=adminsService.updateAexist(aid);

        return new ResponseEntity<>(id,HttpStatus.OK);
    }

}
