package com.zp.manage_cms.controller;

import com.zp.manage_cms.service.CmsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.BaseController;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Author : zhengpanone
 * Date : 2024/1/24 10:27
 * Version : v1.0.0
 * Description: TODO
 */
@Controller
public class CmsPagePreviewController extends BaseController {
    @Autowired
    CmsPageService cmsPageService;

    @RequestMapping(value = "/cms/preview/{pageId}", method = RequestMethod.GET)
    public void preview(@PathVariable("pageId") String pageId) throws IOException {
        // 执行静态化
        String pageHtml = cmsPageService.getPageHtml(pageId);
        // 通过response对象将内容输出
        ServletOutputStream outputStream = response.getOutputStream();

        outputStream.write(pageHtml.getBytes(StandardCharsets.UTF_8));


    }


}
