package com.zp.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 启动类
 *
 * @author zheng
 */
@SpringBootApplication
@EntityScan("com.zp.model.cms") //扫描实体类
@ComponentScan(basePackages = {"com.zp.api"}) //扫描接口
@ComponentScan(basePackages = {"com.zp.manage_cms"}) //扫描本项目下所有的类
@ComponentScan(basePackages = {"com.zp.exception"}) // 扫描common下面的包
public class ManageCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageCmsApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}


