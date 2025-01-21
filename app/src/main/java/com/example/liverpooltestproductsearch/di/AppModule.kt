package com.example.liverpooltestproductsearch.di

import com.example.liverpooltestproductsearch.data.network.ApiLiverpool
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.example.liverpooltestproductsearch.utils.Constants.BASE_URL
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApiLiverpool(retrofit: Retrofit): ApiLiverpool {
        return retrofit.create(ApiLiverpool::class.java)
    }
}