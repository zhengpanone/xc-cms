package com.zp.xc.model.cms.response;

import com.zp.xc.model.cms.CmsConfig;
import com.zp.xc.common.response.ResponseResult;
import com.zp.xc.common.response.ResultCode;
import lombok.Data;

/**
 * CmsConfigResult
 *
 * @author zhengpanone
 * @since 2021-12-23
 */
@Data
public class CmsConfigResult extends ResponseResult {
    CmsConfig cmsConfig;
    public CmsConfigResult(ResultCode resultCode, CmsConfig cmsConfig) {
        super(resultCode);
        this.cmsConfig = cmsConfig;
    }
}
