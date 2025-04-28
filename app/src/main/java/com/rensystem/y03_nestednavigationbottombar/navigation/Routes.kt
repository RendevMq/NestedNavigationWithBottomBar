package com.rensystem.y03_nestednavigationbottombar.navigation

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

//Routes.kt
// Gráficos principales
@Serializable
sealed interface Graph {
    @Serializable
    data object RootGraph : Graph

    @Serializable
    data object AuthGraph : Graph

    @Serializable
    data object MainGraph : Graph

    @Serializable
    data object NotificationGraph : Graph

    @Serializable
    data object SettingGraph : Graph

    @Serializable
    data object ProfileGraph : Graph
}

// Pantallas dentro del flujo de autenticación (Auth)
@Serializable
sealed interface AuthRouteScreen {
    @Serializable
    data object Login : AuthRouteScreen

    @Serializable
    data object SignUp : AuthRouteScreen

    @Serializable
    data object ForgotPassword : AuthRouteScreen
}

// Pantallas dentro del flujo principal (Main), que van en el Bottom Bar
@Serializable
sealed interface MainRouteScreen {
    @Serializable
    data object Home : MainRouteScreen

    @Serializable
    data object Profile : MainRouteScreen

    @Serializable
    data object Notification : MainRouteScreen

    @Serializable
    data object Setting : MainRouteScreen
}

// Pantallas del flujo de Profile (detalles de perfil)
@Serializable
sealed interface ProfileRouteScreen {
    @Serializable
    data class ProfileDetail(val profileInfo: ProfileInfo) : ProfileRouteScreen

    @Serializable
    data object ProfileRouteDetail : ProfileRouteScreen//Para poder usar navigation en su graph

}

// Pantallas del flujo de configuración
@Serializable
sealed interface SettingRouteScreen {
    @Serializable
    data object SettingDetail : SettingRouteScreen
}

// Pantallas del flujo de notificaciones
@Serializable
sealed interface NotificationRouteScreen {
    @Serializable
    data object NotificationDetail : NotificationRouteScreen
}

@Serializable
@Parcelize
data class ProfileInfo(
    val id: String,
    val name: String,
    val description: String,
    @DrawableRes val imageRes: Int
) : Parcelable
