package com.zp.model.cms;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author zhengpanone
 * @date: Created in 2021-06-18-12:50
 * @email zhengpanone@hotmail.com
 * @modified By:
 * 站点模型
 */
@Data
@Document(collection = "cms_site")
public class CmsSite {
    //站点ID
    @Id
    private String siteId;

    //站点名称
    private String siteName;

    // 站点url
    private String siteDomain;

    //站点端口
    private String sitePort;

    // 站点访问地址
    private String siteWebPath;

    // 创建时间
    private Date siteCreateTime;
}
