package com.example.sixtcars.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sixtcars.ui.theme.SixtOrange
import com.example.sixtcars.R
import com.example.sixtcars.ui.screens.*

@Composable
fun SixtCarsApp(carsViewModel: CarsViewModel, modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) },
        bottomBar = {
            BottomNavigation(
                backgroundColor = SixtOrange,
                elevation = 5.dp
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = Screen.CarsList.route, Modifier.padding(innerPadding)) {
            composable(Screen.CarsList.route) { CarsList(carsViewModel.carsUiState, modifier) }
            composable(Screen.CarsMap.route) { CarsMap(carsViewModel.carsUiState, modifier) }
        }
    }
}