package com.bq2015.mvpdemo.model.biz;

import com.bq2015.mvpdemo.model.UserBean;

/**
 * Created by Kylin on 2016/6/1.
 */
public class UserBiz implements IUserBiz {
    @Override
    public void login(String userName, String passWord, LoginListener listener) {
        //登录成功
        if (userName == "fqq" && passWord == "123") {
            UserBean user = new UserBean();
            user.setUserName(userName);
            user.setPassWord(passWord);
            listener.loginSuccess(user);
        } else {
            listener.loginFeild();
        }
    }
}
