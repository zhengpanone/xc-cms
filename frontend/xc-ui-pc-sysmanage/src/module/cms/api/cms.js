import http from '@/base/api/public'
import querystring from 'querystring'

let sysConfig = require('@/../config/sysConfig')
let apiUrl = sysConfig.xcApiUrlPre;

export const page_list = (page, size, params) => {
    let query = querystring.stringify(params)
    // 请求服务端的页面查询接口
    return http.requestGet(apiUrl + '/cms/page/list/' + page + '/' + size + '?' + query)
}

export const site_list = (page, size) => {
    // 查询站点接口
    return http.requestGet(apiUrl + '/cms/site/list?page=' + page + '&size=' + size)
}

export const template_list = (page, size) => {
    // 查询站点接口
    return http.requestGet(apiUrl + '/cms/template/list?page=' + page + '&size=' + size)
}

export const page_add = (params) => {
    return http.requestPost(apiUrl + '/cms/page/add', params)
}

export const page_get = (pageId) => {
    return http.requestGet(apiUrl + '/cms/page/get/' + pageId)
}

export const page_edit = (pageId, params) => {
    return http.requestPut(apiUrl + '/cms/page/edit/' + pageId, params)
}

export const page_delete = (pageId) => {
    return http.requestDelete(apiUrl + '/cms/page/delete/' + pageId)
}

export const page_publishPage=(pageId)=>{
    return http.requestPost(apiUrl+ '/cms/page/publishPage/'+ pageId)
}


