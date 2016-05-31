package com.bq2015.mvpdemo.model.biz;

/**
 * Created by Kylin on 2016/5/31.
 */
public interface  IUserBiz {
    void login(String userName,String passWord,LoginListener listener);
}
