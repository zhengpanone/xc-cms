package com.zp.manage_cms.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author : zhengpanone
 * Date : 2024/4/28 17:38
 * Version : v1.0.0
 * Description:
 * 1. 创建ex_cms_postpage交换机
 * 2. 每个Cms Client创建一个队列与交换机绑定
 * 3. 每个Cms Client程序配置队列名称和routingKey，将站点ID作为routingKey
 */
@Configuration
public class RabbitmqConfig {

    // 交换机的名称
    public static final String EX_ROUTING_CMS_POST_PAGE = "ex_routing_cms_post_page";

    /**
     * 交换机配置使用direct类型
     * @return
     */
    @Bean(EX_ROUTING_CMS_POST_PAGE)
    public Exchange exchangeTopicInform() {
        return ExchangeBuilder.directExchange(EX_ROUTING_CMS_POST_PAGE).durable(true).build();
    }

}
