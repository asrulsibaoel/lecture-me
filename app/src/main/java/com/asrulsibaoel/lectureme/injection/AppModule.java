package com.asrulsibaoel.lectureme.injection;

import android.content.Context;
import android.support.annotation.NonNull;

import com.asrulsibaoel.lectureme.LectureMe;

import dagger.Module;
import dagger.Provides;

@Module
public final class AppModule {
    @NonNull
    private final LectureMe mApp;

    public AppModule(@NonNull LectureMe app) {
        mApp = app;
    }

    @Provides
    public Context provideAppContext() {
        return mApp;
    }

    @Provides
    public LectureMe provideApp() {
        return mApp;
    }
}
