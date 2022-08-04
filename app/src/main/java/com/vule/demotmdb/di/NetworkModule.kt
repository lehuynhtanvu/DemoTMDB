package com.vule.demotmdb.di

import androidx.annotation.NonNull
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.vule.demotmdb.api.LiveDataCallAdapterFactory
import com.vule.demotmdb.api.MovieService
import com.vule.demotmdb.api.RequestInterceptor
import com.vule.demotmdb.api.TheDiscoverService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@NonNull okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideDiscoverService(@NonNull retrofit: Retrofit): TheDiscoverService {
        return retrofit.create(TheDiscoverService::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieService(@NonNull retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }
}