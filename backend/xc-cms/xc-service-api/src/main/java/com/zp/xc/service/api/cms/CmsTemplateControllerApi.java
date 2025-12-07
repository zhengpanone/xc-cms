package com.zp.xc.service.api.cms;

import com.zp.xc.common.response.QueryResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * CmsTemplateControllerApi
 *
 * @author zhengpanone
 * @since 2021-12-13
 */
@Tag(name = "cms模板管理接口", description = "cms模板管理接口")
public interface CmsTemplateControllerApi {

    @Operation(summary = "查询模板站点", description = "查询模板站点信息")
    QueryResponseResult findList();
}
