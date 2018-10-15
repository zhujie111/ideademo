package com.newer.springbootdemo3.controller;

import com.newer.springbootdemo3.domain.Departs;
import com.newer.springbootdemo3.service.DepartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departs")
public class DeprtController {

    @Autowired
    private DepartsService departsService;

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> findAll(){
        List<Departs> departs=departsService.findAll2();

        return new ResponseEntity<>(departs, HttpStatus.OK);
    }


    @RequestMapping(value = "/departschangestate",method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> updateDeexist(@RequestParam Integer deid){
          int result=departsService.updateDeexist(deid);

          return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @RequestMapping(value = "/updata",method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> changeDeexist(@RequestParam Integer deid){
        int result1=departsService.changeDeexist(deid);

        return new ResponseEntity<>(result1,HttpStatus.OK);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> addDeparts(@RequestBody Departs departs){
        int result2=departsService.addDeparts(departs);

        Map<String,Object> map=new HashMap<>();

        map.put("result",result2);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }


    @RequestMapping(value = "/{deid}",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> findById(@PathVariable("deid")Integer deid){
        List<Departs> departs=departsService.findById(deid);

        return new ResponseEntity<>(departs,HttpStatus.OK);
    }



}
