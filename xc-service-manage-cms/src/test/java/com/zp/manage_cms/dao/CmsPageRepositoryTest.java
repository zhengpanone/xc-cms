package com.zp.manage_cms.dao;

import com.zp.model.cms.CmsPage;
import com.zp.model.cms.CmsPageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    CmsPageRepository cmsPageRepository;

    @Test
    public void testInsert() {
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("S02");
        cmsPage.setPageName("测试页面2");
        cmsPage.setTemplateId("t02");
        cmsPage.setPageCreateTime(new Date());
        List<CmsPageParam> cmsPageParams = new ArrayList<>();
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param2");
        cmsPageParam.setPageParamValue("value2");
        cmsPageParams.add(cmsPageParam);
        cmsPage.setPageParams(cmsPageParams);
        CmsPage save = cmsPageRepository.save(cmsPage);
        System.out.println(save);
    }
    @Test
    public void testFindById(){
        Optional<CmsPage> result = cmsPageRepository.findById("650f18b84f8406c8a0967a7f");
        result.ifPresent(System.out::println);
    }

    @Test
    public void testFindAll() {
        List<CmsPage> all = cmsPageRepository.findAll();
//        System.out.println(all);
        for (CmsPage cmsPage : all) {
            CmsPage save = cmsPageRepository.save(cmsPage);
            System.out.println(save);
        }

    }

    //自定义条件查询
    @Test
    public void testFindAllByExample() {
        int page = 0;
        int size = 10;
        PageRequest pageable = PageRequest.of(page, size);
        //条件值对象
        CmsPage cmsPage = new CmsPage();
//        cmsPage.setTemplateId("5a925be7b00ffc4b3c1578b5");
        cmsPage.setPageAliase("轮播");
// 条件匹配器
        // .contains() 包含\ .startsWith() 前缀匹配
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());

        // 定义Example
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        List<CmsPage> content = all.getContent();
        System.out.println(content);
    }

    //分页查询
    @Test
    public void testFindPage() {
        // 分页参数
        int page = 0;//从0开始
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);

        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);
    }

    @Test
    public void testFindByPageName() {
        CmsPage cmsPage = cmsPageRepository.findByPageName("update page name");
        System.out.println(cmsPage);

    }

    @Test
    public void testDelete() {
        cmsPageRepository.deleteById("5fadf7a7c7583f2e9c5561a3");
    }

    @Test
    public void testUpdate() {
        Optional<CmsPage> optional = cmsPageRepository.findById("5a96114fb00ffc4b44f63e06");
        if (optional.isPresent()) {
            CmsPage cmsPage = optional.get();
            cmsPage.setPageAliase("test01");
            CmsPage save = cmsPageRepository.save(cmsPage);
            System.out.println(save);
        }


    }
}
