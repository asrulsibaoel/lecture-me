package com.asrulsibaoel.lectureme.injection;

import com.asrulsibaoel.lectureme.view.impl.StudentLoginActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = StudentLoginViewModule.class)
public interface StudentLoginViewComponent {
    void inject(StudentLoginActivity activity);
}