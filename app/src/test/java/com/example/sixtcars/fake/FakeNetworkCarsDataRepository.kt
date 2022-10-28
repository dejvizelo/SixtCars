package com.example.sixtcars.fake

import com.example.sixtcars.data.CarsDataRepository
import com.example.sixtcars.network.CarModel

class FakeNetworkCarsDataRepository : CarsDataRepository {
    override suspend fun getCarsData(): List<CarModel> {
        return FakeDataSource.carsList
    }
}