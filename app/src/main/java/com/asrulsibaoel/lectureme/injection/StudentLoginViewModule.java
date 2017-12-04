package com.asrulsibaoel.lectureme.injection;

import android.support.annotation.NonNull;

import com.asrulsibaoel.lectureme.interactor.StudentLoginInteractor;
import com.asrulsibaoel.lectureme.interactor.impl.StudentLoginInteractorImpl;
import com.asrulsibaoel.lectureme.presenter.StudentLoginPresenter;
import com.asrulsibaoel.lectureme.presenter.impl.StudentLoginPresenterImpl;
import com.asrulsibaoel.lectureme.presenter.loader.PresenterFactory;

import dagger.Module;
import dagger.Provides;

@Module
public final class StudentLoginViewModule {
    @Provides
    public StudentLoginInteractor provideInteractor() {
        return new StudentLoginInteractorImpl();
    }

    @Provides
    public PresenterFactory<StudentLoginPresenter> providePresenterFactory(@NonNull final StudentLoginInteractor interactor) {
        return new PresenterFactory<StudentLoginPresenter>() {
            @NonNull
            @Override
            public StudentLoginPresenter create() {
                return new StudentLoginPresenterImpl(interactor);
            }
        };
    }
}
