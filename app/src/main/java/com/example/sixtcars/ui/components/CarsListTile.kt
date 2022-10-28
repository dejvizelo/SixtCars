package com.example.sixtcars.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.sixtcars.R
import com.example.sixtcars.network.CarModel

@Composable
fun CarListTile(car: CarModel, modifier: Modifier = Modifier) {
    Column {
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = car.modelName, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(car.carImageUrl)
                    .build(),
                error = painterResource(R.drawable.fallback_car_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = car.modelName,
                modifier = modifier.width(200.dp),
                contentScale = ContentScale.Fit
            )
        }
        InfoBar(car = car, modifier = modifier.padding(vertical = 10.dp))
        Divider(modifier = modifier.padding(vertical = 10.dp))
    }
}