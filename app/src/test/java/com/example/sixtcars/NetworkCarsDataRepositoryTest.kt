package com.example.sixtcars

import com.example.sixtcars.data.NetworkCarsDataRepository
import com.example.sixtcars.fake.FakeCarsApiService
import com.example.sixtcars.fake.FakeDataSource
import org.junit.Test
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals

class NetworkCarsDataRepositoryTest {
    @Test
    fun networkCarsPhotosRepository_getCarData_verifyList() = runTest {
        val repository = NetworkCarsDataRepository(
            carsApiService = FakeCarsApiService()
        )
        assertEquals(FakeDataSource.carsList, repository.getCarsData())
    }
}