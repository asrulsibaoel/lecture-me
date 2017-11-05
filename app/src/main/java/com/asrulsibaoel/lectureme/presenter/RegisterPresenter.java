package com.asrulsibaoel.lectureme.presenter;


import com.asrulsibaoel.lectureme.view.RegisterView;

/**
 * Created by Hery Kuswandi on 3/13/2017.
 */

public interface RegisterPresenter extends  BasePresenter<RegisterView> {

    void doRegister(String email, String password, String name);

}
