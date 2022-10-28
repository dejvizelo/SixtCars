package com.example.sixtcars

import com.example.sixtcars.fake.FakeDataSource
import com.example.sixtcars.fake.FakeNetworkCarsDataRepository
import com.example.sixtcars.rules.TestDispatcherRule
import com.example.sixtcars.ui.screens.CarsUiState
import com.example.sixtcars.ui.screens.CarsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class CarsViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun carsViewModel_getCarsData_verifyCarsUiStateSuccess() =
        runTest {
            val carsViewModel = CarsViewModel(
                carsDataRepository = FakeNetworkCarsDataRepository()
            )
            assertEquals(
                CarsUiState.Success(FakeDataSource.carsList),
                carsViewModel.carsUiState
            )
        }
}