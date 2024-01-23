package com.zp.api.cms;

import com.zp.model.cms.CmsPage;
import com.zp.model.request.QueryPageRequest;
import com.zp.response.CommonPage;
import com.zp.response.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Interface CmsPageControllerApi
 *
 * @author zheng
 */
@Tag(name = "cms页面管理接口", description = "cms页面管理接口")
public interface CmsPageControllerApi {
    /**
     * 页面查询
     *
     * @param page             页码
     * @param size             记录树
     * @param queryPageRequest 查询参数
     * @return 分页的page
     */
    @Operation(summary = "分页查询页面列表")
    @Parameters({
            @Parameter(name = "page", description = "页码", required = true, in = ParameterIn.PATH),
            @Parameter(name = "size", description = "每页记录数", required = true, in = ParameterIn.PATH)
    })
    CommonResult<CommonPage<CmsPage>> findList(int page, int size, QueryPageRequest queryPageRequest);

    /**
     * 新增页面
     *
     * @param page
     * @return
     */
    @Operation(summary = "新增页面")
    CommonResult<CmsPage> addCmsPage(CmsPage page);

    @Operation(summary = "根据ID查询页面信息")
    @Parameters(@Parameter(name = "id", description = "页面ID", required = true, in = ParameterIn.PATH))
    CmsPage findById(String id);

    @Operation(summary = "修改页面")
    @Parameters({
            @Parameter(name = "id", description = "页面ID")
    })
    CommonResult<?> edit(String id, CmsPage page);

    @Operation(summary = "通过ID删除页面")
    @Parameter(name = "id", description = "页面ID")
    CommonResult<?> delete(String id);
}
