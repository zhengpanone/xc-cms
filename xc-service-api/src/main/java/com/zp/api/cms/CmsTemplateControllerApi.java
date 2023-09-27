package com.zp.api.cms;

import com.zp.model.cms.CmsTemplate;
import com.zp.response.CommonPage;
import com.zp.response.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * CmsTemplateControllerApi
 *
 * @author zhengpanone
 * @since 2021-12-13
 */
@Tag(name = "cms模板管理接口", description = "cms模板管理")
public interface CmsTemplateControllerApi {
    @Operation(summary = "查询模板站点",description = "查询模板")
    CommonResult<CommonPage<CmsTemplate>> findList( Integer pageNum, Integer pageSize);
}
