package com.zp.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "页面查询条件")
public class QueryPageRequest {
    //接收页面查询条件
    @Schema(description ="站点ID")
    private String siteId;

    @Schema(description ="页面ID")
    private String pageId;

    @Schema(description ="页面名称")
    private String pageName;

    @Schema(description ="别名")
    private String pageAliase;

    @Schema(description ="模板ID")
    private String templateId;

}
