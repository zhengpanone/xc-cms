package com.zp.api.system;

import com.zp.framework.response.CommonResult;
import com.zp.model.system.SysDictionary;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 12:59
 * Version : v1.0.0
 * Description: TODO
 */
@Tag(name = "system-字段管理接口", description = "字典管理")
public interface SysDictionaryControllerApi {

    @Operation(summary = "查询所有字典")
    CommonResult<List<SysDictionary>> queryAll();

    @Operation(summary = "根据dType查询数据字典")
    public CommonResult<SysDictionary> findBydType(String dType);


}
