package com.zp.manage_cms.controller;

import com.zp.api.cms.CmsSiteControllerApi;
import com.zp.manage_cms.service.CmsSiteService;
import com.zp.model.cms.CmsSite;
import com.zp.response.CommonPage;
import com.zp.response.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/list")
    public CommonResult<CommonPage<CmsSite>> findList(@RequestParam(value = "page",defaultValue = "1") Integer pageNum, @RequestParam(value = "size",defaultValue = "5") Integer pageSize) {
        Page<CmsSite> page = cmsSiteService.findList(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(page));
    }
}
