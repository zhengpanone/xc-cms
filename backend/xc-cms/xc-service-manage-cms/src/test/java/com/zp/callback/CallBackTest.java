package com.zp.callback;

/**
 * CallBackTest
 *
 * @author zhengpanone
 * @since 2021-12-16
 */
public class CallBackTest {
    public static void main(String[] args) {

        CallBackResponse callBackResponse = new CallBackResponse();
        CallBackRequest callBackRequest = new CallBackRequest(callBackResponse);
        callBackRequest.request("1+1");

    }
}
