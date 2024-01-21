import http from '@/base/api/public'
import querystring from 'querystring'
let sysConfig = require('@/../config/sysConfig')
let apiUrl = sysConfig.xcApiUrlPre;

export const page_list = (page,size,params)=>{
    // 请求服务端的页面查询接口
   return  http.requestGet(apiUrl+'/cms/page/list/'+page+'/'+size,params)
}




