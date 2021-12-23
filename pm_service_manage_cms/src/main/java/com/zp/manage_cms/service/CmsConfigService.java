package com.zp.manage_cms.service;

import com.zp.manage_cms.dao.CmsConfigRepository;
import com.zp.model.cms.CmsConfig;
import com.zp.model.cms.response.CmsConfigResult;
import com.zp.model.cms.response.CmsPageResult;
import com.zp.response.CommonCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * CmsConfigService
 *
 * @author zhengpanone
 * @since 2021-12-23
 */
@Service
public class CmsConfigService {
    @Autowired
    private CmsConfigRepository cmsConfigRepository;

    public CmsConfigResult getConfigById(String id){
        Optional<CmsConfig> optional = cmsConfigRepository.findById(id);
        if(optional.isPresent()){
            CmsConfig cmsConfig = optional.get();
            return new CmsConfigResult(CommonCode.SUCCESS, cmsConfig);
        }
        return  new CmsConfigResult(CommonCode.FAIL, null);
    }
}
