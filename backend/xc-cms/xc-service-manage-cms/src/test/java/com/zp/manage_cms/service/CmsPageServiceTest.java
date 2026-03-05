package com.zp.manage_cms.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Author : zhengpanone
 * Date : 2024/1/24 10:07
 * Version : v1.0.0
 * Description: TODO
 */
@SpringBootTest
public class CmsPageServiceTest {
    @Autowired
    CmsPageService cmsPageService;

    @Test
    public void testGetPageHtml() {
        String content = cmsPageService.getPageHtml("5a795ac7dd573c04508f3a56");
        System.out.println(content);

    }
}
