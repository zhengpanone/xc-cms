package com.zp.manage_course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


/**
 * Author : zhengpanone
 * Date : 2024/4/29 15:30
 * Version : v1.0.0
 * Description: TODO
 */
@SpringBootApplication
@EntityScan("com.zp.model.course")//扫描实体类
@ComponentScan(basePackages = {"com.zp.api", "com.zp.manage_course", "com.zp.framework"})
@EnableDiscoveryClient
public class ManageCourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageCourseApplication.class, args);
    }
}
