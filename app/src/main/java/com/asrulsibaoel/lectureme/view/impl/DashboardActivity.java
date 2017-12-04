package com.asrulsibaoel.lectureme.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.asrulsibaoel.lectureme.R;
import com.asrulsibaoel.lectureme.view.DashboardView;
import com.asrulsibaoel.lectureme.presenter.loader.PresenterFactory;
import com.asrulsibaoel.lectureme.presenter.DashboardPresenter;
import com.asrulsibaoel.lectureme.injection.AppComponent;
import com.asrulsibaoel.lectureme.injection.DashboardViewModule;
import com.asrulsibaoel.lectureme.injection.DaggerDashboardViewComponent;

import javax.inject.Inject;

public final class DashboardActivity extends BaseActivity<DashboardPresenter, DashboardView> implements DashboardView {
    @Inject
    PresenterFactory<DashboardPresenter> mPresenterFactory;

    // Your presenter is available using the mPresenter variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Your code here
        // Do not call mPresenter from here, it will be null! Wait for onStart or onPostCreate.
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerDashboardViewComponent.builder()
                .appComponent(parentComponent)
                .dashboardViewModule(new DashboardViewModule())
                .build()
                .inject(this);
    }

    @NonNull
    @Override
    protected PresenterFactory<DashboardPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }
}
