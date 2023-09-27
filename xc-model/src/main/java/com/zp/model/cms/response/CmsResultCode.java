package com.zp.model.cms.response;


import com.zp.response.IErrorCode;
import com.zp.response.ResultCode;
import lombok.ToString;

/**
 * Created by mrt on 2018/3/5.
 */
@ToString
public enum CmsResultCode implements IErrorCode {
    CMS_ADDPAGE_EXISTSNAME(24001,"页面名称已存在！"),

    CMS_GENERATEHTML_DATAURLISNULL(24002,"从页面信息中找不到获取数据的url！"),
    CMS_GENERATEHTML_DATAISNULL(24003,"根据页面的数据url获取不到数据！"),
    CMS_GENERATEHTML_TEMPLATEISNULL(24004,"页面模板为空！"),
    CMS_GENERATEHTML_HTMLISNULL(24005,"生成的静态html为空！"),
    CMS_GENERATEHTML_SAVEHTMLERROR(24005,"保存静态html出错！"),
    CMS_PAGE_NOTEXISTS(24006,"页面不存在"),
    CMS_COURSE_PERVIEWISNULL(24007,"预览页面为空！");

    //操作代码
    int code;
    //提示信息
    String message;
    private CmsResultCode( int code, String message){
        this.code = code;
        this.message = message;
    }





    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
