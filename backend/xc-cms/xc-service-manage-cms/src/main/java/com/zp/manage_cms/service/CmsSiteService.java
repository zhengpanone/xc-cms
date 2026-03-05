package com.zp.manage_cms.service;

import com.zp.manage_cms.dao.CmsSitRepository;
import com.zp.model.cms.CmsSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/06/25 18:02.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */
@Service
public class CmsSiteService {
    @Autowired
    CmsSitRepository cmsSitRepository;

    public Page<CmsSite> findList(Integer pageSize, Integer pageNum) {
        if (pageSize <= 0) {
            pageSize = 1;
        }
        pageSize = pageSize - 1;
        Pageable pageable = PageRequest.of(pageSize, pageNum);
        Page<CmsSite> page = cmsSitRepository.findAll(pageable);
        return page;

    }

}
