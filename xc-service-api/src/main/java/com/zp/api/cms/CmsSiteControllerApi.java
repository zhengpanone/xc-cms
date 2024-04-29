package com.zp.api.cms;

import com.zp.model.cms.CmsSite;
import com.zp.framework.response.CommonPage;
import com.zp.framework.response.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "cms站点管理接口", description = "cms站点管理接口")
public interface CmsSiteControllerApi {
    @Operation(summary = "查询所有站点",description = "查询")
    CommonResult<CommonPage<CmsSite>> findList(Integer pageNum,Integer pageSize);
}
