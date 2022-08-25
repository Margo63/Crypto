package com.example.crypto.controller

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.crypto.*

@Composable
fun SetUpOnGraph(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = Screen.Start.route){
        composable(Screen.Start.route){
            StartScreen(navHostController)
        }
        composable(Screen.Main.route){
            MainScreen()
        }
    }
}
@Composable
fun BottomSetUpOnGraph(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = BottomScreen.Home.route){
        composable(BottomScreen.Home.route){
            HomeScreen()
        }
        composable(BottomScreen.Wallet.route){
            WalletScreen()
        }
        composable(BottomScreen.Market.route){
            MarketScreen()
        }
        composable(BottomScreen.Settings.route){
            SettingsScreen()
        }

    }
}

val bottomItems = listOf(
    BottomScreen.Home,
    BottomScreen.Wallet,
    BottomScreen.Market,
    BottomScreen.Settings,
)