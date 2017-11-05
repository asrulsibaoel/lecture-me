package com.asrulsibaoel.lectureme.injection;

import android.content.Context;

import com.asrulsibaoel.lectureme.LectureMe;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Context getAppContext();

    LectureMe getApp();
}