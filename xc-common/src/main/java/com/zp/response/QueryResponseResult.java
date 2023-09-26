package com.zp.response;

import lombok.Data;
import lombok.ToString;

/**
 * 查询返回
 * @author zheng
 */
@Data
public class QueryResponseResult extends ResponseResult {
    QueryResult queryResult;

    public QueryResponseResult(ResultCode resultCode, QueryResult queryResult) {
        super(resultCode);
        this.queryResult = queryResult;
    }
}
