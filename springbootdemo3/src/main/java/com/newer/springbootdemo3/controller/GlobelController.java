package com.newer.springbootdemo3.controller;

import com.newer.springbootdemo3.domain.Admins;
import com.newer.springbootdemo3.exception.HospitalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author shining
 */
@RestController
public class GlobelController {

    @Deprecated
    @RequestMapping("/usersession")
    public ResponseEntity<?> userSession(HttpSession session){
        Admins admins=(Admins) session.getAttribute("loginer");

        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @Deprecated
    @RequestMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session){
        session.removeAttribute("loginer");
        session.invalidate();
        return new ResponseEntity<>(new String("suc"),HttpStatus.OK);
    }

    @RequestMapping("/testError")
    public ResponseEntity<?> testError() throws HospitalException {
        throw new HospitalException("医院对接数据异常!");
    }
}
