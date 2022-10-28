package com.example.sixtcars.data

import com.example.sixtcars.network.CarsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val carsDataRepository: CarsDataRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://cdn.sixt.io/codingtask/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: CarsApiService by lazy {
        retrofit.create(CarsApiService::class.java)
    }

    override val carsDataRepository: CarsDataRepository by lazy {
        NetworkCarsDataRepository(retrofitService)
    }
}