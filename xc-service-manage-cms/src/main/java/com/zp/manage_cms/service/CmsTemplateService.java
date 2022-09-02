package com.zp.manage_cms.service;

import com.zp.manage_cms.dao.CmsTemplateRepository;
import com.zp.model.cms.CmsTemplate;
import com.zp.response.CommonCode;
import com.zp.response.QueryResponseResult;
import com.zp.response.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CmsTemplateService
 *
 * @author zhengpanone
 * @since 2021-12-13
 */
@Service
public class CmsTemplateService {
    @Autowired
    CmsTemplateRepository cmsTemplateRepository;
    public QueryResponseResult findList(){
        QueryResult<CmsTemplate> queryResult = new QueryResult<>();
        List<CmsTemplate> all = cmsTemplateRepository.findAll();
        queryResult.setList(all);
        queryResult.setTotal(all.size());
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }
}
