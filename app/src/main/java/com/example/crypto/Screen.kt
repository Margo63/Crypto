package com.example.crypto

sealed class Screen(val route:String) {
    object Start:Screen("start_screen")
    object Main:Screen("main_screen")
}

sealed class BottomScreen(val route:String,val label:String,val image:Int) {
    object Home:BottomScreen("home_screen","home",R.drawable.ho)
    object Wallet:BottomScreen("wallet_screen","wallet",R.drawable.wallet)
    object Market:BottomScreen("market_screen","market",R.drawable.market)
    object Settings:BottomScreen("setting_screen","settings",R.drawable.set)
}