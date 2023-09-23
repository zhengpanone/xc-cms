package com.zp.model.cms;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 页面模板
 * @author zheng
 */
@Data
@Document(collection = "cms_template")
@ApiModel
public class CmsTemplate {
    //模板ID
    @Id
    @ApiModelProperty("模板ID")
    private String templateId;

    //站点ID
    @ApiModelProperty("站点ID")
    private String siteId;

    // 模板名称
    @ApiModelProperty("模板名称")
    private String templateName;

    //模板参数
    @ApiModelProperty("模板参数")
    private String templateParameter;

    // 模板文件Id
    @ApiModelProperty("模板文件ID")
    private String templateFileId;

}
