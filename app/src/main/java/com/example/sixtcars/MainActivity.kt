package com.example.sixtcars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sixtcars.ui.SixtCarsApp
import com.example.sixtcars.ui.screens.CarsViewModel
import com.example.sixtcars.ui.theme.SixtCarsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SixtCarsTheme {
                val viewModel: CarsViewModel = viewModel(factory = CarsViewModel.Factory)
                SixtCarsApp(viewModel)
            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    SixtCarsTheme {
//        Greeting("Android")
//    }
//}