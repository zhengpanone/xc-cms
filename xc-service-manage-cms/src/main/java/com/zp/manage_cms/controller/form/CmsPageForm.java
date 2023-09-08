package com.zp.manage_cms.controller.form;

import com.zp.model.cms.CmsPageParam;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * CmsPageForm
 *
 * @author zhengpanone
 * @since 2022-09-15
 */

public class CmsPageForm {
    /**
     * 页面名称、别名、访问地址、类型（静态/动态）、页面模版、状态
     */
    //站点ID
    @ApiModelProperty("站点ID")
    private String siteId;
    //页面ID
    @Id
    @ApiModelProperty("页面ID")
    private String pageId;
    //页面名称
    @ApiModelProperty("页面名称")
    private String pageName;
    //别名
    @ApiModelProperty("别名")
    private String pageAliase;
    //访问地址
    @ApiModelProperty("访问地址")
    private String pageWebPath;
    //参数
    @ApiModelProperty("页面参数")
    private String pageParameter;
    //物理路径
    @ApiModelProperty("页面物理路径")
    private String pagePhysicalPath;
    //类型（静态/动态）
    @ApiModelProperty("页面类型")
    private String pageType;
    //页面模版
    @ApiModelProperty("页面模板")
    private String pageTemplate;
    //页面静态化内容
    private String pageHtml;
    //状态
    @ApiModelProperty("页面状态")
    private String pageStatus;
    //创建时间
    @ApiModelProperty(name = "创建时间")
    private Date pageCreateTime;
    //模版id
    private String templateId;
    //参数列表
    private List<CmsPageParam> pageParams;
    //模版文件Id
    private String templateFileId;
    //静态文件Id
    private String htmlFileId;
    //数据Url
    private String dataUrl;
}
