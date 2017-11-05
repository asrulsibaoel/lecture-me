package com.asrulsibaoel.lectureme.view.impl;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import in.tawari.app.tawarinapp.R;
import in.tawari.app.tawarinapp.injection.AppComponent;
import in.tawari.app.tawarinapp.injection.DaggerLoginViewComponent;
import in.tawari.app.tawarinapp.injection.LoginViewModule;
import in.tawari.app.tawarinapp.presenter.LoginPresenter;
import in.tawari.app.tawarinapp.presenter.loader.PresenterFactory;
import in.tawari.app.tawarinapp.view.LoginView;

public final class LoginActivity extends BaseActivity<LoginPresenter, LoginView> implements LoginView {

    private Button btnLogin, btnRegister;
    private EditText inputEmail, inputPassword;
    private String email, password;

    @Inject
    PresenterFactory<LoginPresenter> mPresenterFactory;
    private ProgressDialog dialog;

    // Your presenter is available using the mPresenter variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Your code here
        btnLogin = (Button) findViewById(R.id.login);
        btnRegister = (Button) findViewById(R.id.signup);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);

        dialog = new ProgressDialog(this);
        dialog.setIndeterminate(true);
        dialog.setMessage("Checking credentials");

        // Do not call mPresenter from here, it will be null! Wait for onStart or onPostCreate.
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {

        /**
         * action for login proccess
         */

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                email = inputEmail.getText().toString();
                password = inputPassword.getText().toString();
                mPresenter.doLogin(email, password);

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });

        super.onPostCreate(savedInstanceState);
    }



    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerLoginViewComponent.builder()
                .appComponent(parentComponent)
                .loginViewModule(new LoginViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<LoginPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }

    @Override
    public void dismissDialog() {
        dialog.dismiss();
    }

    @Override
    public void showDialog() {
        dialog.show();
    }

    @Override
    public void gotoDashBoard() {
        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
