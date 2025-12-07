package com.zp.xc.model.cms;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

/**
 * CmsConfig
 *
 * @author zhengpanone
 * @since 2021-12-23
 */
@Data
@Schema(description = "Cms配置")
@Document(collection = "cms_config")
public class CmsConfig {
    @Id
    private String id; // 主键
    @Schema(description="数据模型名称")
    private String name;// 数据模型名称
    @Schema(description="数据模型")
    private List<CmsConfigModel> models;// 数据模型项目
}
