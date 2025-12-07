package com.zp.xc.model.cms;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Id;
import java.util.Map;

/**
 * CmsConfigModel
 *
 * @author zhengpanone
 * @since 2021-12-23
 */
@Data
@Schema(description = "Cms配置模型")
public class CmsConfigModel {
    @Id
    private String key;// 主键
    @Schema(description="项目名称")
    private String name; // 项目名称
    @Schema(description="项目url")
    private String url; // 项目url
    private Map mapValue; // 项目复杂值
    private String value; // 项目简单值
}
