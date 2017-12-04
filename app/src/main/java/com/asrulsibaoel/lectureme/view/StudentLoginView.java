package com.asrulsibaoel.lectureme.view;

import android.support.annotation.UiThread;

@UiThread
public interface StudentLoginView {

    void showDialog();
    void dismissDialog();
    void gotoDashBoard();
    void loginError(String message);
}