package com.zp.manage_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 13:02
 * Version : v1.0.0
 * Description: TODO
 */
@SpringBootApplication
@EntityScan("com.zp.model.course")//扫描实体类
@ComponentScan(basePackages = {"com.zp.api.system","com.zp.manage_system","com.zp.framework"})//扫描接口
@EnableDiscoveryClient
public class ManageSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageSystemApplication.class, args);
    }
}
