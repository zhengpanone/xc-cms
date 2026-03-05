package com.zp.model.system;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 12:51
 * Version : v1.0.0
 * Description: TODO
 */
@Data
public class SysDictionaryValue {
    @Field("sd_id")
    private String sdId;

    @Field("sd_name")
    private String sdName;

    @Field("sd_status")
    private String sdStatus;
}
