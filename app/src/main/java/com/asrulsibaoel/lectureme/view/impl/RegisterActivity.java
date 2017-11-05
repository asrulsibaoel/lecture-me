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
import in.tawari.app.tawarinapp.injection.DaggerRegisterViewComponent;
import in.tawari.app.tawarinapp.injection.RegisterViewModule;
import in.tawari.app.tawarinapp.presenter.RegisterPresenter;
import in.tawari.app.tawarinapp.presenter.loader.PresenterFactory;
import in.tawari.app.tawarinapp.view.RegisterView;

public final class RegisterActivity extends BaseActivity<RegisterPresenter, RegisterView> implements RegisterView {

    private Button btnRegister, btnLogin;
    private EditText inputEmail, inputPassword,inputName;
    private String email, password,name;

    @Inject
    PresenterFactory<RegisterPresenter> mPresenterFactory;
    private ProgressDialog dialog;

    // Your presenter is available using the mPresenter variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Your code here
        btnRegister = (Button) findViewById(R.id.register);
        btnLogin = (Button) findViewById(R.id.login);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        inputName = (EditText) findViewById(R.id.name);

        dialog = new ProgressDialog(this);
        dialog.setIndeterminate(true);
        dialog.setMessage("Checking credentials");

        // Do not call mPresenter from here, it will be null! Wait for onStart or onPostCreate.
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {

        /**
         * action for register proccess
         */

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                email = inputEmail.getText().toString();
                password = inputPassword.getText().toString();
                name = inputName.getText().toString();
                mPresenter.doRegister(email, password,name);

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoLogin();
            }
        });

        super.onPostCreate(savedInstanceState);
    }



    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerRegisterViewComponent.builder()
                .appComponent(parentComponent)
                .registerViewModule(new RegisterViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<RegisterPresenter> getPresenterFactory() {
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
    public void gotoLogin() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void registerError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
