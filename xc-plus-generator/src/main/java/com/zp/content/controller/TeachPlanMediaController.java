package com.zp.content.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zp.content.service.TeachPlanMediaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhengpan
 */
@Slf4j
@RestController
@RequestMapping("teachPlanMedia")
public class TeachPlanMediaController {

    @Autowired
    private TeachPlanMediaService  teachPlanMediaService;
}
