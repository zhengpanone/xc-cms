package com.zp.manage_cms.controller;

import com.zp.api.cms.CmsPageControllerApi;
import com.zp.manage_cms.service.CmsPageService;
import com.zp.model.cms.CmsPage;
import com.zp.model.request.QueryPageRequest;
import com.zp.response.CommonPage;
import com.zp.response.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {
    @Autowired
    CmsPageService cmsPageService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public CommonResult<CommonPage<CmsPage>> findList(@PathVariable("page") int pageNum, @PathVariable("size") int pageSize, QueryPageRequest queryPageRequest) {
       /* QueryResult<CmsPage> queryResult = new QueryResult<>();
        List<CmsPage> list = new ArrayList<>();
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageName("testPage");
        list.add(cmsPage);
        queryResult.setList(list);
        queryResult.setTotal(1);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;*/
        Page<CmsPage> page = cmsPageService.findList(pageNum, pageSize, queryPageRequest);
        return CommonResult.success(CommonPage.restPage(page));

    }

    @Override
    @PostMapping("/add")
    public CommonResult<CmsPage> addCmsPage(@RequestBody CmsPage cmsPage) {
        CmsPage addResult = cmsPageService.add(cmsPage);
        return CommonResult.success(addResult);
    }

    @Override
    @GetMapping("/get/{id}")
    public CmsPage findById(@PathVariable("id") String id) {
        return cmsPageService.findById(id);
    }

    @Override
    @PutMapping("/edit/{id}")
    public CommonResult<?> edit(@PathVariable("id") String id, @RequestBody CmsPage page) {
        String message = cmsPageService.update(id, page);
        return CommonResult.success();
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public CommonResult<?> delete(@PathVariable("id") String id) {
         cmsPageService.delete(id);
         return CommonResult.success();
    }
}
