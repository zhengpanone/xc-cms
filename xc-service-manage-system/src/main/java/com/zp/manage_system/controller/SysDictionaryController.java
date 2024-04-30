package com.zp.manage_system.controller;

import com.zp.api.system.SysDictionaryControllerApi;
import com.zp.framework.response.CommonResult;
import com.zp.manage_system.service.SysDictionaryService;
import com.zp.model.system.SysDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author : zhengpanone
 * Date : 2024/4/30 13:01
 * Version : v1.0.0
 * Description: TODO
 */
@RestController
@RequestMapping("/system")
public class SysDictionaryController implements SysDictionaryControllerApi {
    @Autowired
    SysDictionaryService sysDictionaryService;

    @Override
    @GetMapping("/dictionary/queryAll")
    public CommonResult<List<SysDictionary>> queryAll() {
        return CommonResult.success(sysDictionaryService.queryAll());
    }

    @Override
    @GetMapping("/dictionary/get/{dType}")
    public CommonResult<SysDictionary> findBydType(@PathVariable("dType") String dType) {
        return CommonResult.success(sysDictionaryService.findBydType(dType));
    }
}
