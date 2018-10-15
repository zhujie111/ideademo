package com.newer.springbootdemo3.logback;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MongoDBAppender extends UnsynchronizedAppenderBase<LoggingEvent> implements ApplicationContextAware{
    private static LogRepository logRepository;


    @Override
    protected void append(LoggingEvent eventObject) {
        MyLog myLog=new MyLog();
        myLog.setLevel(eventObject.getLevel().toString());
        myLog.setMessage(eventObject.getFormattedMessage());
        myLog.setThread(eventObject.getThreadName());
        myLog.setTs(LocalDateTime.now());
        //将日志事件写入mongodb
        logRepository.save(myLog);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //注入非spring容器提供的bean
        if(applicationContext.
                   getAutowireCapableBeanFactory().
                   getBean(LogRepository.class)!=null){
               logRepository=applicationContext.getAutowireCapableBeanFactory().getBean(LogRepository.class);
           }
    }
}
