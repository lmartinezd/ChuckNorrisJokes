package com.lmf.chucknorrisjokes.di.module

import com.lmf.chucknorrisjokes.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModuleActivity {

    @ContributesAndroidInjector
    internal abstract fun contributesSplashActivity(): MainActivity
}