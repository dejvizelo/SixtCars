package com.example.sixtcars.ui.screens

import ErrorScreen
import LoadingScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.sixtcars.R
import com.example.sixtcars.network.CarModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun CarsMap(
    carsUiState: CarsUiState,
    modifier: Modifier = Modifier
) {
    when (carsUiState) {
        is CarsUiState.Loading -> LoadingScreen(modifier)
        is CarsUiState.Success -> MapWithMarkers(carsUiState.cars, modifier)
        is CarsUiState.Error -> ErrorScreen(modifier)
    }
}

@Composable
fun MapWithMarkers(cars: List<CarModel>, modifier: Modifier = Modifier) {
    val markerLocations = cars.map { LatLng(it.latitude, it.longitude) }
    val cameraPositionState = rememberCameraPositionState {
        CameraPosition.fromLatLngZoom(markerLocations[0], 15f)
    }

    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        markerLocations.forEach {
            Marker(state = MarkerState(it))
        }
    }

}