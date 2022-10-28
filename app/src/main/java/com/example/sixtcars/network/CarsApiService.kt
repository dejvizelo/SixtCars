package com.example.sixtcars.network

import retrofit2.http.GET

interface CarsApiService {
    @GET("cars")
    suspend fun getData(): List<CarModel>
}