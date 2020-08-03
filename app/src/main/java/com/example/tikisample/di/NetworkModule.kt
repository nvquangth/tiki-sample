package com.example.tikisample.di
import com.example.mvvmarchitecture.utils.Constants
import com.example.tikisample.BuildConfig
import com.example.tikisample.data.remote.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }
}

fun provideOkHttpClient(): OkHttpClient {
    val okHttpBuilder = OkHttpClient.Builder()
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    okHttpBuilder.apply {
        addInterceptor(logging)
        connectTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
        readTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
    }

    return okHttpBuilder.build()
}

fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
    .client(okHttpClient)
    .baseUrl(BuildConfig.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)
