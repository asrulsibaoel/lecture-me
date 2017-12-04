package com.asrulsibaoel.lectureme.presenter;


import com.asrulsibaoel.lectureme.models.response.Login.LoginResponse;
import com.asrulsibaoel.lectureme.view.LecturerLoginView;

public interface LecturerLoginPresenter extends BasePresenter<LecturerLoginView> {

    void doLogin(String email, String password);

    Boolean isLoggedIn(LoginResponse loginResponse);

    void saveToPrefs();
}