package com.zp.xc.manage_cms.controller;

import com.zp.xc.service.api.cms.CmsTemplateControllerApi;
import com.zp.xc.manage_cms.service.CmsTemplateService;
import com.zp.xc.common.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CmsTemplateController
 *
 * @author zhengpanone
 * @since 2021-12-13
 */
@RestController
@RequestMapping("/cms/template")
public class CmsTemplateController implements CmsTemplateControllerApi {
    @Autowired
    CmsTemplateService cmsTemplateService;
    @GetMapping("list")
    @Override
    public QueryResponseResult findList() {
        return cmsTemplateService.findList();
    }
}
