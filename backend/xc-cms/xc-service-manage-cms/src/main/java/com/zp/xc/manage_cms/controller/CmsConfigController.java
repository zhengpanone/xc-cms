package com.zp.xc.manage_cms.controller;


import com.zp.xc.manage_cms.service.CmsPageService;
import com.zp.xc.model.cms.response.CmsConfigResult;
import com.zp.xc.service.api.cms.CmsConfigControllerApi;
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
