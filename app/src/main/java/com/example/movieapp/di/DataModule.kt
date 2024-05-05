package com.example.movieapp.di

import android.app.Application
import com.example.movieapp.data.database.MovieDao
import com.example.movieapp.data.database.MovieDatabase
import com.example.movieapp.data.network.api.ApiFactory
import com.example.movieapp.data.repositoryImpl.DatabaseRepositoryImpl
import com.example.movieapp.data.repositoryImpl.NetworkRepositoryImpl
import com.example.movieapp.domain.dataBaseRepository.DatabaseRepository
import com.example.movieapp.domain.networkRepository.NetworkRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepositoryNetwork(impl: NetworkRepositoryImpl): NetworkRepository

    @ApplicationScope
    @Binds
    fun bindRepositoryDatabase(impl: DatabaseRepositoryImpl): DatabaseRepository

    companion object{

        @ApplicationScope
        @Provides
        fun providesMovieDao(
            application: Application
        ) = MovieDatabase.getInstance(application).movieDao()

        @ApplicationScope
        @Provides
        fun provideApiService() = ApiFactory.apiService
    }
}