package com.bq2015.mvpdemo.presenter;

import android.os.Handler;
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
    private Handler handler = new Handler();

    public LoginPresenter(ILoginView loginView) {
        mLoginView = loginView;
        mUserBiz = new UserBiz();
    }

    public void login() {
        handler.post((new Runnable() {
            @Override
            public void run() {
                mLoginView.showProgress();
                SystemClock.sleep(1500);
                mUserBiz.login(mLoginView.getUserName(), mLoginView.getPassWord(), LoginPresenter.this);
            }
        }));


    }

    @Override
    public void loginSuccess(final UserBean userBean) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                mLoginView.hideProgres();
                mLoginView.jump2Main(userBean);
            }
        });

    }

    @Override
    public void loginFeild() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                mLoginView.hideProgres();
            }
        });

       // login();
    }
}
