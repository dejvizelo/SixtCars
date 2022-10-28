package com.example.sixtcars.fake

import com.example.sixtcars.network.CarModel

object FakeDataSource {
    const val id = "WMWSW31030T222518"
    const val modelIdentifier = "mini"
    const val modelName = "MINI"
    const val name = "Vanessa"
    const val make = "BMW"
    const val group = "MINI"
    const val color = "midnight_black"
    const val series = "MINI"
    const val fuelType = "D"
    const val fuelLevel = 0.7
    const val transmission = "M"
    const val licensePlate = "M-VO0259"
    const val latitude = 48.134557
    const val longitude = 11.576921
    const val innerCleanliness = "REGULAR"
    const val carImageUrl = "https://cdn.sixt.io/codingtask/images/mini.png"

    val carsList = listOf(
        CarModel(
            id, modelIdentifier, modelName, name, make, group, color, series, fuelType, fuelLevel,
            transmission, licensePlate, latitude, longitude, innerCleanliness, carImageUrl
        ),
        CarModel(
            id, modelIdentifier, modelName, name, make, group, color, series, fuelType, fuelLevel,
            transmission, licensePlate, latitude, longitude, innerCleanliness, carImageUrl
        )
    )
}