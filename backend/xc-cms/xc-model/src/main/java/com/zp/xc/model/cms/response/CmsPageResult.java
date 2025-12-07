package com.zp.xc.model.cms.response;

import com.zp.xc.model.cms.CmsPage;
import com.zp.xc.common.response.ResponseResult;
import com.zp.xc.common.response.ResultCode;
import lombok.Data;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/06/25 19:07.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */
@Data
public class CmsPageResult extends ResponseResult {
    CmsPage cmsPage;

    public CmsPageResult(ResultCode resultCode, CmsPage cmsPage) {
        super(resultCode);
        this.cmsPage = cmsPage;
    }
}
