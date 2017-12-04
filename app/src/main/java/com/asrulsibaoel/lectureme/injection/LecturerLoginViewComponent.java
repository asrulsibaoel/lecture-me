package com.asrulsibaoel.lectureme.injection;

import com.asrulsibaoel.lectureme.view.impl.LecturerLoginActivity;
import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = LecturerLoginViewModule.class)
public interface LecturerLoginViewComponent {
    void inject(LecturerLoginActivity activity);
}