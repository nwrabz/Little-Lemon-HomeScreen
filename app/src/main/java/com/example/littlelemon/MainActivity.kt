package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Home.route) {
                    composable(Home.route) {
                        HomeScreen(navController)
                    }
                    composable(
                        DishDetails.route + "/{${DishDetails.argDishId}}",
                        arguments = listOf(navArgument(DishDetails.argDishId) { type = NavType.IntType })
                    ) {
                        val id = requireNotNull(it.arguments?.getInt(DishDetails.argDishId)) { "Dish id is null" }
                        DishDetails(id)
                    }
                }
            }
        }
    }
}

