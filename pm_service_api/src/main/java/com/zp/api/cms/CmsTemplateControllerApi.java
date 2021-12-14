package com.zp.api.cms;

import com.zp.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * CmsTemplateControllerApi
 *
 * @author zhengpanone
 * @since 2021-12-13
 */
@Api(value = "cms模板管理接口", tags = {"cms模板管理接口,提供增删改查"})
public interface CmsTemplateControllerApi {
    @ApiOperation("查询模板站点")
    QueryResponseResult findList();
}
