package com.rensystem.y03_nestednavigationbottombar.navigation

object Graph {
    const val RootGraph = "rootGraph"
    const val AuthGraph = "authGraph"
    const val MainScreenGraph = "mainScreenGraph"
    const val NotificationGraph = "notificationGraph"
    const val SettingGraph = "settingGraph"
}

sealed class AuthRouteScreen(val route: String) {
    data object Login : AuthRouteScreen("login")
    data object Forget : AuthRouteScreen("forget")
    data object SignUp : AuthRouteScreen("signUp")
}

sealed class MainRouteScreen(val route: String) {
    data object Home : MainRouteScreen("home")
    data object Profile : MainRouteScreen("profile")
    data object Notification : MainRouteScreen("notification")
    data object Setting : MainRouteScreen("setting")
}

sealed class NotificationRouteScreen(val route: String) {
    data object NotificationDetail : NotificationRouteScreen("notificationDetail")
}

sealed class SettingRouteScreen(val route: String) {
    data object SettingDetail : SettingRouteScreen("settingDetail")
}
