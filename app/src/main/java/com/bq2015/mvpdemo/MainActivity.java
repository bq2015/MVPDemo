package com.bq2015.mvpdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bq2015.mvpdemo.presenter.LoginPresenter;
import com.bq2015.mvpdemo.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private EditText mUserName;
    private EditText mPassWod;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserName = (EditText) findViewById(R.id.login_et_username);
        mPassWod = (EditText) findViewById(R.id.login_et_passwod);

    }

    public void login(View view) {
        new LoginPresenter(this).login();
    }

    @Override
    public String getUserName() {
        String userName = mUserName.getText().toString().trim();
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this,"用户名不能为空",Toast.LENGTH_SHORT).show();
        }
        return userName;
    }

    @Override
    public String getPassWord() {
        String passWord = mPassWod.getText().toString().trim();
        if (TextUtils.isEmpty(passWord)) {
            Toast.makeText(this,"用户名不能为空",Toast.LENGTH_SHORT).show();
        }
        return passWord;
    }

    @Override
    public void showProgress() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.show();
    }

    @Override
    public void hideProgres() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void jump2Main() {
        Toast.makeText(this,"登录成功，跳转主页",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginFeild() {
        Toast.makeText(this,"登录失败，请重新登录",Toast.LENGTH_SHORT).show();
    }
}
