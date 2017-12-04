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

import com.asrulsibaoel.lectureme.R;
import com.asrulsibaoel.lectureme.injection.AppComponent;
import com.asrulsibaoel.lectureme.injection.DaggerLecturerLoginViewComponent;
import com.asrulsibaoel.lectureme.injection.LecturerLoginViewModule;
import com.asrulsibaoel.lectureme.presenter.LecturerLoginPresenter;
import com.asrulsibaoel.lectureme.presenter.loader.PresenterFactory;
import com.asrulsibaoel.lectureme.view.LecturerLoginView;

import javax.inject.Inject;


public final class LecturerLoginActivity extends BaseActivity<LecturerLoginPresenter, LecturerLoginView> implements LecturerLoginView {

    private Button btnLogin;
    private EditText inputEmail, inputPassword;
    private String email, password;

    @Inject
    PresenterFactory<LecturerLoginPresenter> mPresenterFactory;
    private ProgressDialog dialog;

    // Your presenter is available using the mPresenter variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Your code here
        btnLogin = findViewById(R.id.btn_login);
        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);

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

        super.onPostCreate(savedInstanceState);
    }



    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerLecturerLoginViewComponent.builder()
                .appComponent(parentComponent)
                .lecturerLoginViewModule(new LecturerLoginViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<LecturerLoginPresenter> getPresenterFactory() {
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
        Intent intent = new Intent(LecturerLoginActivity.this, DashboardActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
