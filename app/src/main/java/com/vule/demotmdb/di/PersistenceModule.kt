package com.vule.demotmdb.di

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.vule.demotmdb.room.AppDatabase
import com.vule.demotmdb.room.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PersistenceModule {
    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, "TheMovies.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(@NonNull database: AppDatabase): MovieDao {
        return database.movieDao()
    }
}