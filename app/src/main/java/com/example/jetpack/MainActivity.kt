package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpack.ui.theme.CustomGreen
import com.example.jetpack.ui.theme.JetpackTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
                MyApp()
            }
        }
}

@Composable
fun MyApp(){
        val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "start_screen") {
        composable("start_screen") {
            StartScreen(navController)
        }
        composable("second_screen") {
            SecondScreen(navController)
        }
        composable("third_screen/{userInput}",
            arguments = listOf(navArgument("userInput") {defaultValue = "Nic nie wpisano"}))
        { backStackEntry ->
            val userInput = backStackEntry.arguments?.getString("userInput")
            ThirdScreen(navController, userInput)
        }
        composable("fourth_screen/{userInput}/{selectedOption}",
            arguments = listOf(navArgument("userInput") {defaultValue = "Nic nie wpisano"}))
        {backStackEntry ->
            val userInput = backStackEntry.arguments?.getString("userInput")
            val selectedOption = backStackEntry.arguments?.getString("selectedOption")
            FourthScreen(navController, userInput, selectedOption = selectedOption)
        }
    }
    }