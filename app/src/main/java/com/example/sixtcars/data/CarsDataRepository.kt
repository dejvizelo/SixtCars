package com.example.sixtcars.data

import com.example.sixtcars.network.CarModel
import com.example.sixtcars.network.CarsApiService

interface CarsDataRepository {
    suspend fun getCarsData(): List<CarModel>
}

class NetworkCarsDataRepository(
    private val carsApiService: CarsApiService
) : CarsDataRepository {
    override suspend fun getCarsData(): List<CarModel> {
        return carsApiService.getData()
    }
}