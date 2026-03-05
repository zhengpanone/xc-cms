package com.zp.manage_cms_client.mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zp.manage_cms_client.service.PageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * Author : zhengpanone
 * Date : 2024/4/28 21:29
 * Version : v1.0.0
 * Description: TODO
 */
@Component
public class ConsumerPostPage {
    @Resource
    PageService pageService;

    @RabbitListener(queues = {"${xuecheng.mq.queue}"})
    public void postPage(String msg) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // 解析消息
            Map map = objectMapper.readValue(msg, Map.class);

            String pageId = (String) map.get("pageId");
            // 调用service方法将页面从Gridfs获取页面
            pageService.savePageToServerPath(pageId);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
