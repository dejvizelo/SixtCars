package com.example.sixtcars.ui.screens

import ErrorScreen
import LoadingScreen
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sixtcars.network.CarModel
import com.example.sixtcars.ui.components.CarListTile

@Composable
fun CarsList(
    carsUiState: CarsUiState,
    modifier: Modifier = Modifier
) {
    when (carsUiState) {
        is CarsUiState.Loading -> LoadingScreen(modifier)
        is CarsUiState.Success -> TileList(carsUiState.cars, modifier)
        is CarsUiState.Error -> ErrorScreen(modifier)
    }
}

@Composable
fun TileList(cars: List<CarModel>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(cars) { car ->
            CarListTile(car = car)
        }
    }
}