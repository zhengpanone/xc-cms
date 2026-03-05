import http from './public'
let sysConfig = require('@/../config/sysConfig')
let apiUrl = sysConfig.xcApiUrlPre
/* 数据字典 */
export const sysGetDictionary = dType => {
  return http.requestQuickGet(apiUrl + '/system/dictionary/get/' + dType)
}
/* 获取jwt令牌 */
export const getjwt = () => {
  return http.requestQuickGet('/openapi/auth/userjwt')
}
