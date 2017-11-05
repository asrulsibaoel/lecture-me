package com.asrulsibaoel.lectureme;

import android.app.Application;
import android.support.annotation.NonNull;

import com.asrulsibaoel.lectureme.injection.AppComponent;
import com.asrulsibaoel.lectureme.injection.AppModule;
import com.asrulsibaoel.lectureme.injection.DaggerAppComponent;
import com.asrulsibaoel.lectureme.util.QBResRequestExecutor;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public final class LectureMe extends Application {
    private AppComponent mAppComponent;
    private static LectureMe instance;
    private QBResRequestExecutor qbResRequestExecutor;

    public static LectureMe getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initApplication();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        Fabric.with(this, new Crashlytics());
    }

    @NonNull
    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    private void initApplication(){
        instance = this;
    }

    public synchronized QBResRequestExecutor getQbResRequestExecutor() {
        return qbResRequestExecutor == null
                ? qbResRequestExecutor = new QBResRequestExecutor()
                : qbResRequestExecutor;
    }
}