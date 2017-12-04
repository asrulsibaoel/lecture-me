package com.asrulsibaoel.lectureme.presenter.impl;

import android.support.annotation.NonNull;

import com.asrulsibaoel.lectureme.presenter.DashboardPresenter;
import com.asrulsibaoel.lectureme.view.DashboardView;
import com.asrulsibaoel.lectureme.interactor.DashboardInteractor;

import javax.inject.Inject;

public final class DashboardPresenterImpl extends BasePresenterImpl<DashboardView> implements DashboardPresenter {
    /**
     * The interactor
     */
    @NonNull
    private final DashboardInteractor mInteractor;

    // The view is available using the mView variable

    @Inject
    public DashboardPresenterImpl(@NonNull DashboardInteractor interactor) {
        mInteractor = interactor;
    }

    @Override
    public void onStart(boolean viewCreated) {
        super.onStart(viewCreated);

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
}