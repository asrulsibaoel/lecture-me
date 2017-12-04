package com.asrulsibaoel.lectureme.injection;

import android.support.annotation.NonNull;

import com.asrulsibaoel.lectureme.interactor.LecturerLoginInteractor;
import com.asrulsibaoel.lectureme.interactor.impl.LecturerLoginInteractorImpl;
import com.asrulsibaoel.lectureme.presenter.LecturerLoginPresenter;
import com.asrulsibaoel.lectureme.presenter.impl.LecturerLoginPresenterImpl;
import com.asrulsibaoel.lectureme.presenter.loader.PresenterFactory;

import dagger.Module;
import dagger.Provides;

@Module
public final class LecturerLoginViewModule {
    @Provides
    public LecturerLoginInteractor provideInteractor() {
        return new LecturerLoginInteractorImpl();
    }

    @Provides
    public PresenterFactory<LecturerLoginPresenter> providePresenterFactory(@NonNull final LecturerLoginInteractor interactor) {
        return new PresenterFactory<LecturerLoginPresenter>() {
            @NonNull
            @Override
            public LecturerLoginPresenter create() {
                return new LecturerLoginPresenterImpl(interactor);
            }
        };
    }
}
