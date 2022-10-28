package com.example.sixtcars.fake

import com.example.sixtcars.network.CarModel
import com.example.sixtcars.network.CarsApiService

class FakeCarsApiService : CarsApiService {
    override suspend fun getData(): List<CarModel> {
        return FakeDataSource.carsList
    }
}