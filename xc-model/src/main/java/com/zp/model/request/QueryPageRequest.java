package com.zp.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求模型,作为查询条件
 *
 * @author zheng
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryPageRequest {
    //接收页面查询条件
    @ApiModelProperty("站点ID")
    private String siteId;

    @ApiModelProperty("页面ID")
    private String pageId;

    @ApiModelProperty("页面名称")
    private String pageName;

    @ApiModelProperty("别名")
    private String pageAliase;

    @ApiModelProperty("模板ID")
    private String templateId;

}
