package com.zp.manage_cms_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Author : zhengpanone
 * Date : 2024/4/28 17:36
 * Version : v1.0.0
 * Description:
 */
@EntityScan("com.zp.model.cms") //扫描实体类
@ComponentScan(basePackages = {"com.zp.manage_cms_client", "com.zp.framework"}) //扫描接口
@SpringBootApplication
@EnableDiscoveryClient
public class ManageCmsClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageCmsClientApplication.class, args);
    }
}
