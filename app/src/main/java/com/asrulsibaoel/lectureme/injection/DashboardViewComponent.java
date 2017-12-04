package com.asrulsibaoel.lectureme.injection;

import com.asrulsibaoel.lectureme.view.impl.DashboardActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = DashboardViewModule.class)
public interface DashboardViewComponent {
    void inject(DashboardActivity activity);
}