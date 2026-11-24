package com.example.trivify.di

import com.example.trivify.common.Constants
import com.example.trivify.data.datasources.remote.TriviaApi
import com.example.trivify.data.repositories.TriviaRepository
import com.example.trivify.data.repositories.TriviaRepositoryImpl
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
    fun provideTriviaApi(): TriviaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TriviaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTriviaRepository(api: TriviaApi): TriviaRepository {
        return TriviaRepositoryImpl(api)
    }
}