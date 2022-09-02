package com.zp.api.cms;

import com.zp.model.cms.CmsConfig;
import com.zp.model.cms.response.CmsConfigResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * CmsConfigControllerApi
 *
 * @author zhengpanone
 * @since 2021-12-23
 */
@Api(value = "cms配置管理接口", tags = {"cms配置管理接口"})
public interface CmsConfigControllerApi {
    @ApiOperation("根据ID查询CMS配置信息")
    CmsConfigResult getModel(String id);
}
