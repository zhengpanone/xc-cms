package com.zp.model.course;

import lombok.Data;

import java.util.List;

/**
 * Author : zhengpanone
 * Date : 2024/4/29 16:35
 * Version : v1.0.0
 * Description: TODO
 */
@Data
public class TeachPlanNode extends TeachPlan {

    List<TeachPlanNode> children;
}
