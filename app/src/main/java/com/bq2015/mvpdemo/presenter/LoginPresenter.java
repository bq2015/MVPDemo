package com.bq2015.mvpdemo.presenter;

import android.os.SystemClock;

import com.bq2015.mvpdemo.model.UserBean;
import com.bq2015.mvpdemo.model.biz.LoginListener;
import com.bq2015.mvpdemo.model.biz.UserBiz;
import com.bq2015.mvpdemo.view.ILoginView;

/**
 *  登录执行者:链接View层和Model层
 * Created by Kylin on 2016/6/1.
 */
public class LoginPresenter implements LoginListener {

    private final UserBiz mUserBiz;
    private ILoginView mLoginView;

    public LoginPresenter(ILoginView loginView) {
        mLoginView = loginView;
        mUserBiz = new UserBiz();
    }

    public void login() {
        mLoginView.showProgress();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                mUserBiz.login(mLoginView.getUserName(),mLoginView.getPassWord(),LoginPresenter.this);
            }
        });
    }

    @Override
    public void loginSuccess(UserBean userBean) {
      mLoginView.hideProgres();
        mLoginView.jump2Main();
    }

    @Override
    public void loginFeild() {
        mLoginView.hideProgres();
        login();
    }
}
