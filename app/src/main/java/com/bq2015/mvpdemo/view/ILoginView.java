package com.bq2015.mvpdemo.view;

import com.bq2015.mvpdemo.model.UserBean;

/**
 * @ Description 登录试图层接口
 * Created by Kylin on 2016/6/1.
 */
public interface ILoginView {
    /**
     * @ Description: 获取用户名
     * @return 用户名
     */
    String getUserName();

    /**
     * @ Description 获取用户密码
     * @ return 密码
     */
    String getPassWord();

    /**
     * @ Description 加载中
     */
    void showProgress();

    /**
     * @ Description 加载结束
     */
    void hideProgres();

    /**
     *  @ Description 登录成功跳转主页
     */
    void jump2Main(UserBean userBean);

    /**
     * @ Description 登录失败，重新加载
     */
    void LoginFeild();
}
