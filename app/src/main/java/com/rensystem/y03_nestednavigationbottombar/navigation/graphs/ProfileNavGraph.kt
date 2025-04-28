package com.rensystem.y03_nestednavigationbottombar.navigation.graphs

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph
import com.rensystem.y03_nestednavigationbottombar.navigation.ProfileInfo
import com.rensystem.y03_nestednavigationbottombar.navigation.ProfileRouteScreen
import com.rensystem.y03_nestednavigationbottombar.screens.profile.ProfileDetailScreen
import kotlin.reflect.typeOf
import com.rensystem.y03_nestednavigationbottombar.navigation.type.createNavType

@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.profileNavGraph(
    rootNavController: NavHostController,
    sharedTransitionScope: SharedTransitionScope,
) {
    composable<ProfileRouteScreen.ProfileDetail>(
        typeMap = mapOf(typeOf<ProfileInfo>() to createNavType<ProfileInfo>())
    ) { backStackEntry ->
        val profileInfo: ProfileRouteScreen.ProfileDetail = backStackEntry.toRoute()
        ProfileDetailScreen(
            sharedTransitionScope = sharedTransitionScope,
            animatedContentScope = this,
            profileInfo = profileInfo.profileInfo,
            rootNavController = rootNavController
        )
    }
}
