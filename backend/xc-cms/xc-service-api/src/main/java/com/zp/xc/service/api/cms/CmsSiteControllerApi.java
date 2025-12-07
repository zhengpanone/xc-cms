package com.zp.xc.service.api.cms;

import com.zp.xc.common.response.QueryResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "cms站点管理接口", description = "cms站点管理接口")
public interface CmsSiteControllerApi {
    @Operation(summary = "查询所有站点", description = "查询所有站点信息")
    QueryResponseResult findList();
}
