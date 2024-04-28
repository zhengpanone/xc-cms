package com.zp.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author : zhengpanone
 * Date : 2024/2/8 20:19
 * Version : v1.0.0
 * Description: Rabbitmq config
 */
@Configuration
public class RabbitmqConfig {

    public static final String QUEUE_INFORM_EMAIL = "queue_inform_email";

    public static final String QUEUE_INFORM_SMS = "queue_inform_sms";

    public static final String EXCHANGE_TOPIC_INFORM = "exchange_topic_inform";
    public static final String ROUTING_KEY_EMAIL = "inform.#.email.#";

    public static final String ROUTING_KEY_SMS = "inform.#.sms.#";


    /**
     * 声明交换机
     */
    @Bean(EXCHANGE_TOPIC_INFORM)
    public Exchange exchangeTopicInform() {
        // durable(true)持久化，mq重启后交换机还在
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPIC_INFORM).durable(true).build();
    }

    /**
     * 声明队列
     */
    @Bean(QUEUE_INFORM_EMAIL)
    public Queue QUEUE_INFORM_EMAIL() {
        return new Queue(QUEUE_INFORM_EMAIL);
    }

    /**
     * 声明队列
     */
    @Bean(QUEUE_INFORM_SMS)
    public Queue QUEUE_INFORM_SMS() {
        return new Queue(QUEUE_INFORM_EMAIL);
    }

    /**
     * ROUTING_KEY_EMAIL队列绑定交换机，指定routingKey
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_EMAIL(@Qualifier(QUEUE_INFORM_EMAIL) Queue queue,
                                              @Qualifier(EXCHANGE_TOPIC_INFORM) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_EMAIL).noargs();
    }
    /**
     * ROUTING_KEY_SMS队列绑定交换机，指定routingKey
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS(@Qualifier(QUEUE_INFORM_SMS) Queue queue,
                                            @Qualifier(EXCHANGE_TOPIC_INFORM) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_SMS).noargs();
    }
}
