package com.asrulsibaoel.lectureme.view;

import android.support.annotation.UiThread;

@UiThread
public interface LecturerLoginView {

    void showDialog();
    void dismissDialog();
    void gotoDashBoard();
    void loginError(String message);
}