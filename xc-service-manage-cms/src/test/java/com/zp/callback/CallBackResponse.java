package com.zp.callback;

import java.util.concurrent.TimeUnit;

/**
 * CallBackResponse 被调程序
 *
 * @author zhengpanone
 * @since 2021-12-16
 */
public class CallBackResponse {
    public void handler(CallBack callBack,String request){
        System.out.println(callBack.getClass()+"问的问题是:"+request);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = "\n答案是2";
        callBack.solve(result);
    }
}
