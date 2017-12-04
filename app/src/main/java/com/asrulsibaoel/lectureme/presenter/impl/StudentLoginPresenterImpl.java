package com.asrulsibaoel.lectureme.presenter.impl;

import android.support.annotation.NonNull;

import com.asrulsibaoel.lectureme.interactor.LecturerLoginInteractor;
import com.asrulsibaoel.lectureme.interactor.StudentLoginInteractor;
import com.asrulsibaoel.lectureme.models.response.Login.LoginResponse;
import com.asrulsibaoel.lectureme.presenter.LecturerLoginPresenter;
import com.asrulsibaoel.lectureme.presenter.StudentLoginPresenter;
import com.asrulsibaoel.lectureme.services.ApiService;
import com.asrulsibaoel.lectureme.services.RetrofitServiceGenerator;
import com.asrulsibaoel.lectureme.view.LecturerLoginView;
import com.asrulsibaoel.lectureme.view.StudentLoginView;
import com.pixplicity.easyprefs.library.Prefs;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;

public final class StudentLoginPresenterImpl extends BasePresenterImpl<StudentLoginView> implements StudentLoginPresenter {
    /**
     * The interactor
     */
    @NonNull
    private final StudentLoginInteractor mInteractor;

    private String token;
    private Integer userId;
    private ApiService apiService;

    // The view is available using the mView variable

    @Inject
    public StudentLoginPresenterImpl(@NonNull StudentLoginInteractor interactor) {
        mInteractor = interactor;
    }

    @Override
    public void onStart(boolean firstStart) {
        super.onStart(firstStart);

        // Your code here. Your view is available using mView and will not be null until next onStop()
    }

    @Override
    public void onStop() {
        // Your code here, mView will be null after this method until next onStart()

        super.onStop();
    }

    @Override
    public void onPresenterDestroyed() {
        /*
         * Your code here. After this method, your presenter (and view) will be completely destroyed
         * so make sure to cancel any HTTP call or database connection
         */

        super.onPresenterDestroyed();
    }

    @Override
    public void doLogin(String email, String password) {

        apiService = RetrofitServiceGenerator.createService(ApiService.class);
        Call<LoginResponse> responseCall = apiService.connectLogin(email, password);

        responseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, retrofit2.Response<LoginResponse> response) {
                mView.dismissDialog();
                try {
                    LoginResponse loginResponse = response.body();
                    loginResponse.getStatus();

                    if(isLoggedIn(loginResponse)){
                        mView.gotoDashBoard();
                    } else {
                        mView.loginError(response.body().getMessage());
                    }

                } catch (RuntimeException e){
                    mView.loginError(e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mView.loginError(t.getMessage());
            }
        });
    }

    @Override
    public Boolean isLoggedIn(LoginResponse loginResponse) {
        if(!loginResponse.getStatus()){
            this.token = loginResponse.getData().getToken().toString();
            this.userId = loginResponse.getData().getUser().getId();
            saveToPrefs();

            return true;
        }

        return false;
    }

    @Override
    public void saveToPrefs() {

        Prefs.putInt("userId", userId);
        Prefs.putString("token", token);
        Prefs.putBoolean("isLoggedIn", true);
    }
}