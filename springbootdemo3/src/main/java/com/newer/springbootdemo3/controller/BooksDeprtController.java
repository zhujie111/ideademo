package com.newer.springbootdemo3.controller;


import com.newer.springbootdemo3.domain.BooksDepart;
import com.newer.springbootdemo3.domain.BooksDepartCounts;
import com.newer.springbootdemo3.domain.Departs;
import com.newer.springbootdemo3.service.BooksDepartService;
import com.newer.springbootdemo3.service.DepartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/booksDepart")
@PreAuthorize("hasRole('USER')")
public class BooksDeprtController {

    @Autowired
    private DepartsService departsService;

    @Autowired
    private BooksDepartService booksDepartService;

    @RequestMapping(value = "/booksdepart",method = RequestMethod.GET)
    public ResponseEntity<?> booksDeparts(){
        List<Departs> departs=departsService.findAll1();

        List<BooksDepartCounts> bdcList=new ArrayList<>();

        for (Departs de:departs){
            BooksDepartCounts bdc=new BooksDepartCounts();

            bdc.setDename(de.getDename());
            List<Integer> list=new ArrayList<>();
            list.add(booksDepartService.getToday(de.getDeid()));
            list.add(booksDepartService.getYestoday(de.getDeid()));
            list.add(booksDepartService.getWeek(de.getDeid()));
            list.add(booksDepartService.getMonth(de.getDeid()));
            list.add(booksDepartService.getQuarter(de.getDeid()));

            bdc.setCountList(list);
            bdcList.add(bdc);
        }
        List<String> times=new ArrayList<>();
        times.add("今天");
        times.add("昨天");
        times.add("本周");
        times.add("本月");
        times.add("本季度");

        BooksDepart booksDepart=new BooksDepart();
        booksDepart.setTimes(times);
        booksDepart.setBooksDepartCounts(bdcList);
        return new ResponseEntity<>(booksDepart, HttpStatus.OK);
    }

    @RequestMapping(value = "/drawDept",method = RequestMethod.GET)
    public ResponseEntity<?> drawDept(){
        //主柱状图
        List<Map<String,Object>> dataList=new ArrayList<>();

        //子柱状图
        List<Map<String,Object>> seriesList=new ArrayList<>();

        List<Departs> departs=departsService.findAll1();

        for (Departs de:departs){
            List<Integer> list=new ArrayList<>();
            list.add(booksDepartService.getToday(de.getDeid()));
            list.add(booksDepartService.getYestoday(de.getDeid()));
            list.add(booksDepartService.getWeek(de.getDeid()));
            list.add(booksDepartService.getMonth(de.getDeid()));
            list.add(booksDepartService.getQuarter(de.getDeid()));

            //单个主状图
            Map<String,Object> data=new HashMap<>();
            data.put("name",de.getDename());
            data.put("y",list.get(4));
            data.put("drilldown",de.getDeid());

            dataList.add(data);

            Map<String,Object> series=new HashMap<>();
            List<List<Object>> seriesDate=new ArrayList<>();
            List<String> times=new ArrayList<>();
            times.add("今天");
            times.add("昨天");
            times.add("本周");
            times.add("本月");
            times.add("本季度");

            for (int i=0;i<times.size();i++){
                List<Object> sdata=new ArrayList<>();

                sdata.add(times.get(i));
                sdata.add(list.get(i));
                seriesDate.add(sdata);
            }
            series.put("name",de.getDename());//子柱图
            series.put("id",de.getDeid());
            series.put("data",seriesDate);

            seriesList.add(series);
        }
        Map<String,Object> result=new HashMap<>();
        result.put("dataList",dataList);
        result.put("seriesList",seriesList);

        return new ResponseEntity<>(result,HttpStatus.OK);

    }
}
