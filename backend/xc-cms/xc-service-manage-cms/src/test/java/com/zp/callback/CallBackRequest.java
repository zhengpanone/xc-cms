package com.zp.callback;

/**
 * CallBackRequest 主调程序
 *
 * @author zhengpanone
 * @since 2021-12-16
 */
public class CallBackRequest implements CallBack {

    private CallBackResponse callBackResponse;

    public CallBackRequest(CallBackResponse callBackResponse) {
        this.callBackResponse = callBackResponse;
    }
    //主调需要解决一个问题，所以他把问题交给被调处理，被调单独创建一个线程，不影响主调程序的运行
    public void request(String question){
        System.out.println("主调程序问了一个问题");
        //B想要帮A处理东西，就必须知道谁让自己处理的，所以要传入a，也要知道a想处理什么，所以要传入question
        new Thread(()->{
            callBackResponse.handler(this,question);
        }).start();
        //A把要处理的事情交给b之后，就可以自己去玩耍了，或者去处理其他事情
        afterTask();
    }

    private void afterTask(){
        System.out.println("主调程序进行其他任务");
    }

    @Override
    public void solve(String result) {
        System.out.println("被调程序接到答案进行后续处理" + result);
    }
}
