package com.zp.manage_cms.controller;

import com.zp.api.cms.CmsSiteControllerApi;
import com.zp.manage_cms.service.CmsSiteService;
import com.zp.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/06/25 18:12.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */
@RestController
@RequestMapping("/cms/site")
public class CmsSiteController implements CmsSiteControllerApi {

    @Autowired
    CmsSiteService cmsSiteService;

    @Override
    @GetMapping("/list/")
    public QueryResponseResult findList() {
        return cmsSiteService.findList();
    }
}
