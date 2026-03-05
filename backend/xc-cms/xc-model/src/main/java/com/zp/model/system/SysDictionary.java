package com.zp.model.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.List;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 12:49
 * Version : v1.0.0
 * Description: TODO
 */
@Data
@Document(collection = "sys_dictionary")
@Schema(description = "sys_dictionary")
public class SysDictionary {

    @Id
    private String id;

    @Field("d_name")
    private String dName;

    @Field("d_type")
    @Setter()
    private String dType;

    @Field("d_value")
    private List<SysDictionaryValue> dValue;

}
