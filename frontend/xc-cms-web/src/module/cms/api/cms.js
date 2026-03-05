import http from '@/base/api/public'
import querystring from 'querystring'
let sysConfig = require('@/../config/sysConfig')
let apiUrl = sysConfig.xcApiUrlPre

// 页面查询
export const pageList = (page, size, params) => {
    //请求服务端页面查询接口
   let  querystr = querystring.stringify(params)
    return http.requestQuickGet(`${apiUrl}/cms/page/list/${page}/${size}?${querystr}`)
}

export const siteList = () => {
    return http.requestQuickGet(`${apiUrl}/cms/site/list`)
}

export const templateList = () => {
    return http.requestQuickGet(`${apiUrl}/cms/template/list`)
}

export const pageAdd = (params) => {
    return http.requestPost(`${apiUrl}/cms/page/add`,params)
}

export const pageById = (id) => {
    return http.requestGet(`${apiUrl}/cms/page/get/${id}`)
}

export const pageUpdate = (id,params) => {
    return http.requestPut(`${apiUrl}/cms/page/edit/${id}`,params)
}

export const pageDelete = (pageId) => {
    return http.requestDelete(`${apiUrl}/cms/page/delete/${pageId}`)
}