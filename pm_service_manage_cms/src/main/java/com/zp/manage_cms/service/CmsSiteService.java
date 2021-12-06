package com.zp.manage_cms.service;

import com.zp.manage_cms.dao.CmsSitRepository;
import com.zp.model.cms.CmsSite;
import com.zp.response.CommonCode;
import com.zp.response.QueryResponseResult;
import com.zp.response.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
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

    public QueryResponseResult findList() {
        QueryResult queryResult = new QueryResult();
        List<CmsSite> all = cmsSitRepository.findAll();
        queryResult.setList(all);
        queryResult.setTotal(all.size());
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

}
