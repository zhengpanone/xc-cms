package com.zp.model.course.request;

import com.zp.framework.request.RequestData;
import lombok.Data;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 14:33
 * Version : v1.0.0
 * Description: TODO
 */
@Data
public class CourseListRequest extends RequestData {
    //公司Id
    private String companyId;
}
