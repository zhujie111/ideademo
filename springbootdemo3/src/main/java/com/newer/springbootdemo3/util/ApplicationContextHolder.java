package com.newer.springbootdemo3.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;



@Component
public class ApplicationContextHolder implements ApplicationContextAware{

    private static ApplicationContext ctx;//获取spring的应用上下文

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx=applicationContext;
    }

    public static <T> T getBean(Class<T> clazz){
        return ctx.getBean(clazz);
    }

    public static <T> T getBean(String name){
        return (T) ctx.getBean(name);
    }


}
