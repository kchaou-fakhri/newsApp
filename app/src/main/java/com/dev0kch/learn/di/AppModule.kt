package com.dev0kch.learn.di

import com.dev0kch.learn.configuration.WSConfiguration
import com.dev0kch.learn.data.api.NewsApi
import com.dev0kch.learn.data.repository.remote.NewsRepositoryImpl
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

    @Singleton
    @Provides
    fun provideApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(WSConfiguration.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(newsApi: NewsApi): NewsRepositoryImpl {
        return NewsRepositoryImpl(newsApi)
    }

}