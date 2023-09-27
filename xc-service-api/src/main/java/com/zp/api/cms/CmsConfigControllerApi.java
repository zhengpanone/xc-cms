package com.zp.api.cms;

import com.zp.model.cms.CmsConfig;
import com.zp.response.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * CmsConfigControllerApi
 *
 * @author zhengpanone
 * @since 2021-12-23
 */
@Tag(name = "cms配置管理接口", description = "cms配置管理接口,提供数据模型管理、查询接口")
public interface CmsConfigControllerApi {
    @Operation(summary = "根据ID查询CMS配置信息")
    CommonResult<CmsConfig> getModel(String id);
}
