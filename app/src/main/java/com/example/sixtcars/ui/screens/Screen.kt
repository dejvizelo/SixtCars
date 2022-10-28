package com.example.sixtcars.ui.screens

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.sixtcars.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object CarsList : Screen("cars-list", R.string.cars_list, Icons.Rounded.List)
    object CarsMap : Screen("map", R.string.cars_map, Icons.Rounded.LocationOn)
}

val items = listOf(
    Screen.CarsList,
    Screen.CarsMap,
)