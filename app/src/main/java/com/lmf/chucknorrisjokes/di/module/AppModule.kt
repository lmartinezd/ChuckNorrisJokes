package com.lmf.chucknorrisjokes.di.module


import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.lmf.chucknorrisjokes.MyApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import com.lmf.chucknorrisjokes.BuildConfig
import com.lmf.chucknorrisjokes.data.repository.JokeApi
import com.lmf.chucknorrisjokes.ui.main.MainContract
import com.lmf.chucknorrisjokes.ui.main.MainPresenter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


@Module
class AppModule {
    @Provides
    @Singleton
    fun provideApplication(app: MyApp): Context = app

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    internal fun okHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideApi(retrofit: Retrofit): JokeApi {
        return retrofit.create(JokeApi::class.java)
    }

    @Provides
        fun provideMainPresenter(api: JokeApi): MainContract.Presenter {
        return MainPresenter(api)
    }

}