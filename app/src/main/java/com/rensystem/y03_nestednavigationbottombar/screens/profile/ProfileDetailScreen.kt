package com.rensystem.y03_nestednavigationbottombar.screens.profile

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rensystem.y03_nestednavigationbottombar.navigation.ProfileInfo

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ProfileDetailScreen(
    rootNavController: NavHostController,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    profileInfo: ProfileInfo
) {
    with(sharedTransitionScope) {
        Column(
            Modifier
                .fillMaxSize()
        ) {
            // Imagen de perfil con la animación compartida
            Box {
                Image(
                    painter = painterResource(id = profileInfo.imageRes),
                    contentDescription = profileInfo.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .sharedElement(
                            sharedTransitionScope.rememberSharedContentState(key = "image-${profileInfo.id}"),
                            animatedVisibilityScope = animatedContentScope
                        )
                        .aspectRatio(1f)
                        .fillMaxWidth()
                )
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "back icon", modifier = Modifier.padding(horizontal = 16.dp , vertical = 32.dp)
                    .clickable {
                        // Navegar hacia atrás
                        rootNavController.popBackStack()
                    }
                    .align(Alignment.TopStart)
                    .background(Color.White.copy(alpha = 0.5f), shape = MaterialTheme.shapes.small)
                    .padding(10.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre del perfil con la animación compartida
            Text(
                profileInfo.name, fontSize = 22.sp,
                modifier = Modifier
                    .sharedElement(
                        sharedTransitionScope.rememberSharedContentState(key = "text-${profileInfo.id}"),
                        animatedVisibilityScope = animatedContentScope
                    )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Descripción del perfil
            Text(
                profileInfo.description, fontSize = 18.sp
            )
        }
    }
}
