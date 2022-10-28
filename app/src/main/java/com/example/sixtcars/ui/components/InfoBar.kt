package com.example.sixtcars.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.sixtcars.network.CarModel
import com.example.sixtcars.R
import kotlin.math.roundToInt

@Composable
fun InfoBar(car: CarModel, modifier: Modifier = Modifier) {
    var fuelLevel = car.fuelLevel
    var transmissionIcon: Int = R.drawable.ic_broken_image
    var transmissionText: String = "Unknown"
    var fuelLevelIcon: Int = R.drawable.ic_broken_image
    var fuelTypeIcon: Int = R.drawable.ic_broken_image
    var fuelTypeText: String = "Unknown"

    if (car.transmission == "A") {
        transmissionIcon = R.drawable.automatic_transmission_icon
        transmissionText = "Automatic"
    }
    else if (car.transmission == "M") {
        transmissionIcon = R.drawable.manual_transmission_icon
        transmissionText = "Manual"
    }

    if (car.fuelType == "E") {
        fuelLevelIcon = R.drawable.ev_station_48px
        fuelTypeIcon = R.drawable.electric_car_48px
        fuelTypeText = "Electric"
    }
    else if (car.fuelType == "D") {
        fuelLevelIcon = R.drawable.local_gas_station_48px
        fuelTypeIcon = R.drawable.oil_barrel_48px
        fuelTypeText = "Diesel"
    }
    else if (car.fuelType == "P") {
        fuelLevelIcon = R.drawable.local_gas_station_48px
        fuelTypeIcon = R.drawable.oil_barrel_48px
        fuelTypeText = "Gasoline"
    }

    val colorText = car.color
    val colorIcon = R.drawable.palette_48px

    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        InfoTile(
            iconId = fuelLevelIcon,
            label = ((car.fuelLevel * 100)).roundToInt().toString() + "%",
        )
        InfoTile(
            iconId = transmissionIcon,
            label = transmissionText
        )
        InfoTile(
            iconId = fuelTypeIcon,
            label = fuelTypeText
        )
        InfoTile(
            iconId = colorIcon,
            label = colorText
        )

    }
}

@Composable
fun InfoTile(iconId: Int, label: String, modifier: Modifier = Modifier) {
    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = label,
            modifier = modifier.size(30.dp)
        )
        Box(modifier = Modifier.height(5.dp))
        Text(text = label, overflow = TextOverflow.Ellipsis)
    }
}