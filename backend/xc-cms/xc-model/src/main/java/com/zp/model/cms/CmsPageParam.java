package com.zp.model.cms;

import lombok.Data;
import lombok.ToString;

/**
 * @author zheng
 */
@Data
@ToString
public class CmsPageParam {
    //参数名称
    private String pageParamName;
    //参数值
    private String pageParamValue;
}
