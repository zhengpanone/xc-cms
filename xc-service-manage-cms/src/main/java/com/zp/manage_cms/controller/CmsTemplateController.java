package com.zp.manage_cms.controller;

import com.zp.api.cms.CmsTemplateControllerApi;
import com.zp.manage_cms.service.CmsTemplateService;
import com.zp.model.cms.CmsTemplate;
import com.zp.framework.response.CommonPage;
import com.zp.framework.response.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Override
    @GetMapping("list")
    public CommonResult<CommonPage<CmsTemplate>> findList(@RequestParam(value = "page",defaultValue = "1") Integer pageNum, @RequestParam(value = "size",defaultValue = "5") Integer pageSize) {
        Page<CmsTemplate> page = cmsTemplateService.findList(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(page));
    }
}
