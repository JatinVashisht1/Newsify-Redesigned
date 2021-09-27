package com.example.newsifyredesigned.di

import com.example.newsifyredesigned.common.Constants
import com.example.newsifyredesigned.data.remote.NewsApi
import com.example.newsifyredesigned.data.repository.NewsRepositoryImpl
import com.example.newsifyredesigned.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsApi() : NewsApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(api: NewsApi) : NewsRepository{
        return NewsRepositoryImpl(api)
    }
}