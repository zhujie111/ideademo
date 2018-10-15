package com.newer.springbootdemo3.logback;


import com.mongodb.BasicDBObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;



import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;



/**
 * @author shining
 */
@Component
@Order(2)
@Aspect
public class WebLogAspect {
    private static Logger logger= LogManager.getLogger("MONGODB");
//    ThreadLocal<Long> startTime=new ThreadLocal<>();


    @Pointcut("execution(public * com.*.*.controller.*.*(..))")
    public void weblog(){}

    @Before("weblog()")
    public void before(JoinPoint joinPoint){
//        logger.info("web请求的前置通知");
//        startTime.set(System.currentTimeMillis());
//        logger.info("请求的方法名:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
//        logger.info("请求注入的参数信息:"+Arrays.toString(joinPoint.getArgs()));

        //获取Servlet请求属性
        ServletRequestAttributes attributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        BasicDBObject object=getBasicDBObject(request,joinPoint);
        logger.info(object);

//        logger.info("请求的uri："+request.getRequestURI());
//        logger.info("请求来源ip:"+request.getRemoteAddr());
//        logger.info("请求方法:"+request.getMethod());
    }

    /*
      获取mongdb保存的基本数据库对象
    * */

    private BasicDBObject getBasicDBObject(HttpServletRequest request, JoinPoint joinPoint) {

        BasicDBObject object=new BasicDBObject();
          object.append("URI:",request.getRequestURI());
          object.append("RemoteAddr:",request.getRemoteAddr());
          object.append("METHOD:",request.getMethod());
          object.append("HEADERS:",getHeaders(request));
          object.append("CLASS_METHOD:",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
          object.append("ARGS:",Arrays.toString(joinPoint.getArgs()));

          return object;

    }

    private Map<String,Object> getHeaders(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();

        Enumeration<String> em=request.getHeaderNames();

        while (em.hasMoreElements()){
            String key=em.nextElement();
            String value=request.getHeader(key);
            map.put(key,value);
        }
        return map;
    }

//    @AfterReturning(returning = "ret",pointcut = "weblog()")
//    public void afterReturn(Object ret){
//        logger.info("web请求后置通知");
//        logger.info("返回值:"+ret.toString());
//        logger.info("耗时:"+(System.currentTimeMillis()-startTime.get()+"毫秒"));
//    }

}

