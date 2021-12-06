package com.zp.model.cms;

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
public class CmsTemplate {
    //站点ID
    private String siteId;
    //模板ID
    @Id
    private String templateId;
    // 模板名称
    private String templateName;
    //模板参数
    private String templateParameter;
    // 模板文件Id
    private String templateFileId;

}
