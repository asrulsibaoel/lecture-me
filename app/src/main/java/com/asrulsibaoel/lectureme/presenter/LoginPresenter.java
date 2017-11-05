package com.asrulsibaoel.lectureme.presenter;

import in.tawari.app.tawarinapp.models.response.Login.LoginResponse;
import in.tawari.app.tawarinapp.view.LoginView;

public interface LoginPresenter extends BasePresenter<LoginView> {

    void doLogin(String email, String password);

    Boolean isLoggedIn(LoginResponse loginResponse);

    void saveToPrefs();
}