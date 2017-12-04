package com.asrulsibaoel.lectureme.injection;

import android.support.annotation.NonNull;

import com.asrulsibaoel.lectureme.interactor.DashboardInteractor;
import com.asrulsibaoel.lectureme.interactor.impl.DashboardInteractorImpl;
import com.asrulsibaoel.lectureme.presenter.loader.PresenterFactory;
import com.asrulsibaoel.lectureme.presenter.DashboardPresenter;
import com.asrulsibaoel.lectureme.presenter.impl.DashboardPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public final class DashboardViewModule {
    @Provides
    public DashboardInteractor provideInteractor() {
        return new DashboardInteractorImpl();
    }

    @Provides
    public PresenterFactory<DashboardPresenter> providePresenterFactory(@NonNull final DashboardInteractor interactor) {
        return new PresenterFactory<DashboardPresenter>() {
            @NonNull
            @Override
            public DashboardPresenter create() {
                return new DashboardPresenterImpl(interactor);
            }
        };
    }
}
