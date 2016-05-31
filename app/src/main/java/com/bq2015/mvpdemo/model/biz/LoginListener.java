package com.bq2015.mvpdemo.model.biz;

import com.bq2015.mvpdemo.model.UserBean;

/**
 * Created by Kylin on 2016/5/31.
 */
public interface LoginListener {
    /**
     * @ Description 登录成功回调
     * @ param userBean  用户数据
     */
    void loginSuccess(UserBean userBean);

    /**
     * @ Description 登录失回调
     */
    void loginFeild();
}
