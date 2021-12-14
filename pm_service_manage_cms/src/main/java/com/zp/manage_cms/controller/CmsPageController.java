package com.zp.manage_cms.controller;

import com.zp.api.cms.CmsPageControllerApi;
import com.zp.manage_cms.service.CmsPageService;
import com.zp.model.cms.CmsPage;
import com.zp.model.cms.response.CmsPageResult;
import com.zp.model.request.QueryPageRequest;
import com.zp.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {
    @Autowired
    CmsPageService cmsPageService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, QueryPageRequest queryPageRequest) {
       /* QueryResult<CmsPage> queryResult = new QueryResult<>();
        List<CmsPage> list = new ArrayList<>();
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageName("testPage");
        list.add(cmsPage);
        queryResult.setList(list);
        queryResult.setTotal(1);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;*/
        return cmsPageService.findList(page, size, queryPageRequest);

    }

    @Override
    @PostMapping("/add")
    public CmsPageResult addCmsPage(@RequestBody CmsPage cmsPage) { // @RequestBody json数据转对象
        return cmsPageService.add(cmsPage);
    }
}
