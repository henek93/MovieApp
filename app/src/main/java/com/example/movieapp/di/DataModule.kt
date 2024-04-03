package com.example.movieapp.di

import com.example.movieapp.data.RepositoryImpl
import com.example.movieapp.data.network.api.ApiFactory
import com.example.movieapp.data.network.api.ApiService
import com.example.movieapp.domain.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindRepository(impl: RepositoryImpl): MovieRepository

    companion object {

        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}