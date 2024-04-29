package com.zp.manage_cms.service;

import com.zp.manage_cms.dao.CmsTemplateRepository;
import com.zp.model.cms.CmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

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

    public Page<CmsTemplate> findList(Integer pageNum, Integer pageSize) {
        // CmsTemplate template = new CmsTemplate();

        /*ExampleMatcher matcher = ExampleMatcher.matching() // 构建对象
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // 改变默认字符串匹配方式：模糊查询
                .withIgnoreCase(true) // 改变默认大小写忽略方式：忽略大小写
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains()) // 采用“包含匹配”的方式查询
                .withIgnorePaths("pageNum", "pageSize");  // 忽略属性，不参与查询
        */
        // Example<CmsTemplate> example = Example.of(template, matcher);

        if (pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize <= 10) {
            pageSize = 10;
        }
        pageNum = pageNum - 1;
        // Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        // Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<CmsTemplate> page = cmsTemplateRepository.findAll(pageable);
        // Page<CmsTemplate> page = cmsTemplateRepository.findAll(example, pageable);

        return page;

    }
}
