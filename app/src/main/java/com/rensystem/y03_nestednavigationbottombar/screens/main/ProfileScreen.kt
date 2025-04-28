package com.rensystem.y03_nestednavigationbottombar.screens.main

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rensystem.y03_nestednavigationbottombar.R
import com.rensystem.y03_nestednavigationbottombar.navigation.ProfileInfo

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ProfileScreen(
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    modifier: Modifier = Modifier,
    navigateToDetail: (ProfileInfo) -> Unit  // Navegar a la vista de detalle pasando el objeto completo
) {
    val profiles = listOf(
        ProfileInfo("1", "Profile 1", "Descripción de perfil 1", R.drawable.profile_image1),
        ProfileInfo("2", "Profile 2", "Descripción de perfil 2", R.drawable.profile_image2),
        ProfileInfo("3", "Profile 3", "Descripción de perfil 3", R.drawable.profile_image3)
    ) // Lista de perfiles de ejemplo

    with(sharedTransitionScope) {

            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(profiles) { profile ->
                    Row(
                        modifier = Modifier
                            .clickable {
                                // Navegar al detalle de un perfil, pasando el objeto completo
                                navigateToDetail(profile)
                            },

                    ) {
                        Spacer(modifier = Modifier.width(8.dp))

                        Image(
                            painter = painterResource(id = profile.imageRes),
                            contentDescription = profile.description,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .sharedElement(
                                    sharedTransitionScope.rememberSharedContentState(key = "image-${profile.id}"),
                                    animatedVisibilityScope = animatedContentScope
                                )
                                .size(100.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            profile.name, fontSize = 18.sp,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .sharedElement(
                                    sharedTransitionScope.rememberSharedContentState(key = "text-${profile.id}"),
                                    animatedVisibilityScope = animatedContentScope
                                )
                        )
                    }
                }
            }

    }
}
