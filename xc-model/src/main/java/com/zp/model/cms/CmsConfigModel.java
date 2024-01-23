package com.zp.model.cms;


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
@Schema(description = "cms configModel")
public class CmsConfigModel {
    @Id
    private String key;// 主键
    @Schema(description = "项目名称", defaultValue = "项目名称", title = "id")
    private String name; // 项目名称
    @Schema(description = "项目url", defaultValue = "http://www.example.com", title = "url")
    private String url; // 项目url
    @Schema(description = "项目复杂值")
    private Map mapValue; // 项目复杂值
    @Schema(description = "项目简单值")
    private String value; // 项目简单值
}
