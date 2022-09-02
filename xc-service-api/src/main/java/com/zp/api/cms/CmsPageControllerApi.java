package com.zp.api.cms;

import com.zp.model.cms.CmsPage;
import com.zp.model.cms.response.CmsPageResult;
import com.zp.model.request.QueryPageRequest;
import com.zp.response.QueryResponseResult;
import com.zp.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Interface CmsPageControllerApi
 *
 * @author zheng
 */
@Api(value = "cms页面管理接口", tags = {"cms页面管理接口"})
public interface CmsPageControllerApi {
    /**
     * 页面查询
     *
     * @param page             页码
     * @param size             记录树
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
     *
     * @param page
     * @return
     */
    @ApiOperation("新增页面")
    CmsPageResult addCmsPage(CmsPage page);

    @ApiOperation("根据ID查询页面信息")
    CmsPage findById(String id);

    @ApiOperation("修改页面")
    CmsPageResult edit(String id, CmsPage page);

    @ApiOperation("通过ID删除页面")
    ResponseResult delete(String id);
}
