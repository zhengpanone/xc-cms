package com.zp.model.cms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
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
@Document(collection = "cms_config")
public class CmsConfig {
    @Id
    private String id; // 主键
    @ApiModelProperty("数据模型名称")
    private String name;// 数据模型名称
    @ApiModelProperty("数据模型")
    private List<CmsConfigModel> models;// 数据模型项目
}
