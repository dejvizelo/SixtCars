package com.example.sixtcars.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.sixtcars.SixtCarsApplication
import com.example.sixtcars.data.CarsDataRepository
import com.example.sixtcars.network.CarModel
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface CarsUiState {
    data class Success(val cars: List<CarModel>) : CarsUiState
    object Error : CarsUiState
    object Loading : CarsUiState
}

class CarsViewModel(private val carsDataRepository: CarsDataRepository) : ViewModel() {
    var carsUiState: CarsUiState by mutableStateOf(CarsUiState.Loading)
        private set

    init {
        getCarsData()
    }

    private fun getCarsData() {
        viewModelScope.launch {
            carsUiState = try {
                CarsUiState.Success(carsDataRepository.getCarsData())
            } catch (e: IOException) {
                CarsUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as SixtCarsApplication)
                val carsDataRepository = application.container.carsDataRepository
                CarsViewModel(carsDataRepository = carsDataRepository)
            }
        }
    }
}