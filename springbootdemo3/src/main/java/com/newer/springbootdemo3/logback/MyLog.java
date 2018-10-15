package com.newer.springbootdemo3.logback;

import java.io.Serializable;
import java.time.LocalDateTime;
/*
* 封装被记录的日志信息
* */
public class MyLog implements Serializable{

    private String id;//编号
    private String level;//级别
    private String message;//日志信息
    private String thread;//日志生成线程名
    private LocalDateTime ts;//日志生成时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public LocalDateTime getTs() {
        return ts;
    }

    public void setTs(LocalDateTime ts) {
        this.ts = ts;
    }
}
