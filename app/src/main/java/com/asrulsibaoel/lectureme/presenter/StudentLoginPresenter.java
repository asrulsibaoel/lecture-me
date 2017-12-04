package com.asrulsibaoel.lectureme.presenter;


import com.asrulsibaoel.lectureme.models.response.Login.LoginResponse;
import com.asrulsibaoel.lectureme.view.StudentLoginView;

public interface StudentLoginPresenter extends BasePresenter<StudentLoginView> {

    void doLogin(String email, String password);

    Boolean isLoggedIn(LoginResponse loginResponse);

    void saveToPrefs();
}