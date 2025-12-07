package com.zp.xc.service.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi userApi(Environment environment) {
        Profiles profiles = Profiles.of("dev");
        String[] paths = {"/**"};
        String[] packagedToMatch = {"com.zp"};
        boolean flag = environment.acceptsProfiles(profiles);

        return GroupedOpenApi.builder().group("default")
                // 是否启用swagger
                .pathsToMatch(paths)
                .packagesToScan(packagedToMatch)
                .build();
        //扫描所有的@RestController注解的类，生成接口文档
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("学成在线系统 Restful API")
                .description("学成在线系统api文档")
                .version("1.0"));
    }

}
