package com.asrulsibaoel.lectureme.view;

/**
 * Created by Hery Kuswandi on 3/13/2017.
 */

public interface RegisterView {
    void showDialog();
    void dismissDialog();
    void gotoLogin();
    void registerError(String message);
}
