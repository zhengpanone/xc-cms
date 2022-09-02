package com.zp.callback;

/**
 * 回调接口
 */
public interface CallBack {
    /**
     * 为什么要写这个回调接口呢？
     * 因为可能不止主调A需要用到被调的处理过程，如果很多地方需要用到被调程序
     * 那么传入被调的方法就不可能只传主调A类，所以要定义一个接口，
     * 传入被调的处理方法的参数就是这个接口对象
     */
    public void solve(String result);
}
