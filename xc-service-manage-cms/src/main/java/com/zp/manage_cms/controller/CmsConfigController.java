package com.zp.manage_cms.controller;

import com.zp.api.cms.CmsConfigControllerApi;
import com.zp.manage_cms.service.CmsPageService;
import com.zp.model.cms.response.CmsConfigResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CmsConfigController
 *
 * @author zhengpanone
 * @since 2021-12-23
 */
@RestController
@RequestMapping("/cms/config")
public class CmsConfigController implements CmsConfigControllerApi {
    @Autowired
    CmsPageService cmsPageService;
    @GetMapping("/getModel/{id}")
    @Override
    public CmsConfigResult getModel(@PathVariable("id") String id) {
        return cmsPageService.getConfigById(id);
    }
}
