package com.zp.api.cms;

import com.zp.model.cms.CmsPage;
import com.zp.model.cms.response.CmsPageResult;
import com.zp.model.request.QueryPageRequest;
import com.zp.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Interface CmsPageControllerApi
 * @author zheng
 */
@Api(value = "cms页面管理接口", tags = {"cms页面管理接口,提供增删改查"})
public interface CmsPageControllerApi {
    /**
     * 页面查询
     * @param page 页码
     * @param size 记录树
     * @param queryPageRequest 查询参数
     * @return
     */
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int")
    })
     QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    /**
     * 新增页面
     * @param page
     * @return
     */
    @ApiOperation("新增页面")
    CmsPageResult addCmsPage(CmsPage page);
}
