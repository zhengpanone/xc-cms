package com.zp.model.cms;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import java.util.Map;

/**
 * CmsConfigModel
 *
 * @author zhengpanone
 * @since 2021-12-23
 */
@Data
@ToString
public class CmsConfigModel {
    private String key;// 主键
    private String name; // 项目名称
    private String url; // 项目url
    private Map mapValue; // 项目复杂值
    private String value; // 项目简单值
}
