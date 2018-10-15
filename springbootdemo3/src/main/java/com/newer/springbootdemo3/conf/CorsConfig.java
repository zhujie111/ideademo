package com.newer.springbootdemo3.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author shining
 */
@Configuration
public class CorsConfig {
    //允许跨域访问的地址列表
    private String[] origins=new String[]{
            "localhost:8080",
            "127.0.0.1:8080"
    };

    /*
     * 返回跨域访问过滤器
     */
    @Bean
    public CorsFilter corsFilter(){
        //基于url的跨域访问配置源
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        //跨域访问配置对象
        CorsConfiguration configuration=new CorsConfiguration();
//        for(String url:origins){
//            //添加允许访问的源地址
//            configuration.addAllowedOrigin("http://"+url);
//            configuration.addAllowedOrigin("https://"+url);
//        }
        //头部数据设置
        configuration.addAllowedHeader("*");
        //请求方法限制
        configuration.addAllowedMethod("*");
        //允许发送HTTP认证信息
//        configuration.setAllowCredentials(true);
        configuration.addAllowedOrigin("*");
        //注册访问路径
        source.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(source);
    }
}