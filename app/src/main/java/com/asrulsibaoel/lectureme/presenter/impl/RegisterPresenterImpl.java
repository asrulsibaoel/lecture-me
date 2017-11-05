package com.asrulsibaoel.lectureme.presenter.impl;

import android.support.annotation.NonNull;

import com.pixplicity.easyprefs.library.Prefs;

import javax.inject.Inject;

import in.tawari.app.tawarinapp.Services.ApiService;
import in.tawari.app.tawarinapp.Services.RetrofitServiceGenerator;
import in.tawari.app.tawarinapp.interactor.RegisterInteractor;
import in.tawari.app.tawarinapp.models.response.Register.RegisterResponse;
import in.tawari.app.tawarinapp.presenter.RegisterPresenter;
import in.tawari.app.tawarinapp.view.RegisterView;
import retrofit2.Call;
import retrofit2.Callback;

public final class RegisterPresenterImpl extends BasePresenterImpl<RegisterView> implements RegisterPresenter {
    /**
     * The interactor
     */
    @NonNull
    private final RegisterInteractor mInteractor;

    private String token;
    private Integer userId;
    private ApiService apiService;

    // The view is available using the mView variable

    @Inject
    public RegisterPresenterImpl(@NonNull RegisterInteractor interactor) {
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
    public void doRegister(String email, String password,String name) {

        apiService = RetrofitServiceGenerator.createService(ApiService.class);
        Call<RegisterResponse> responseCall = apiService.connectRegister(email, password, name);

        responseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, retrofit2.Response<RegisterResponse> response) {
                mView.dismissDialog();
                try {
                    RegisterResponse registerResponse = response.body();
                    if(registerResponse.getError()){
                        mView.registerError(registerResponse.getMessage());
                    }else {

                        mView.registerError("Anda Berhasil Terdaftar Silahkan Login.");
                        mView.gotoLogin();
                    }
                } catch (RuntimeException e){
                    mView.registerError(e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                mView.registerError(t.getMessage());
            }
        });
    }

}