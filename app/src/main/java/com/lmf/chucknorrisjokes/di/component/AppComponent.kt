package com.lmf.chucknorrisjokes.di.component

import com.lmf.chucknorrisjokes.MyApp
import com.lmf.chucknorrisjokes.di.module.AppModule
import com.lmf.chucknorrisjokes.di.module.BuilderModuleActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        BuilderModuleActivity::class
    )
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApp): Builder

        fun build(): AppComponent
    }

    fun inject(application: MyApp)
}