package com.zp.api.cms;

import com.zp.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "cms站点管理接口", tags = {"cms站点管理接口"})
public interface CmsSiteControllerApi {
    @ApiOperation("查询所有站点")
    QueryResponseResult findList();
}
