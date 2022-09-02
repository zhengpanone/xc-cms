package com.zp.model.cms;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel
public class CmsConfigModel {
    @Id
    private String key;// 主键
    @ApiModelProperty("项目名称")
    private String name; // 项目名称
    @ApiModelProperty("项目url")
    private String url; // 项目url
    private Map mapValue; // 项目复杂值
    private String value; // 项目简单值
}
