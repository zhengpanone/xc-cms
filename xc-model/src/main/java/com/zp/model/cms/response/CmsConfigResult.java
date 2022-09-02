package com.zp.model.cms.response;

import com.zp.model.cms.CmsConfig;
import com.zp.response.ResponseResult;
import com.zp.response.ResultCode;
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
