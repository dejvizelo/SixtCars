package com.example.sixtcars

import android.app.Application
import com.example.sixtcars.data.AppContainer
import com.example.sixtcars.data.DefaultAppContainer

class SixtCarsApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}