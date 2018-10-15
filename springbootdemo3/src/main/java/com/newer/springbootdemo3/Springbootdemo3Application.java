package com.newer.springbootdemo3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;



@SpringBootApplication
@MapperScan("com.newer.springbootdemo3.mapper")
@EnableCaching
public class Springbootdemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootdemo3Application.class, args);
	}
}
