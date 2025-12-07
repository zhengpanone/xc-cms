package com.zp.xc.model.cms;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 页面模板
 * @author zheng
 */
@Data
@ToString
@Document(collection = "cms_template")
@Schema(description = "页面模板")
public class CmsTemplate {
    //站点ID
    @Schema(description="站点ID")
    private String siteId;
    //模板ID
    @Id
    @Schema(description="模板ID")
    private String templateId;
    // 模板名称
    @Schema(description="模板名称")
    private String templateName;
    //模板参数
    @Schema(description="模板参数")
    private String templateParameter;
    // 模板文件Id
    @Schema(description="模板文件ID")
    private String templateFileId;

}
