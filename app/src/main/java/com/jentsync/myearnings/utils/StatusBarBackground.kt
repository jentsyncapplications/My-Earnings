package com.jentsync.myearnings.utils


import android.app.Activity
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.core.view.WindowInsetsControllerCompat

@Composable
fun StatusBarBackground(
    backgroundColor: Color,
    navigationBarColor: Color = Color.White
) {
    val view = LocalView.current

    val darkStatusBarIcons = backgroundColor.luminance() > 0.5f
    val darkNavigationBarIcons = navigationBarColor.luminance() > 0.5f

    SideEffect {
        val window = (view.context as Activity).window

        // Enable edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Control system bar icon appearance
        WindowInsetsControllerCompat(window, view).apply {
            isAppearanceLightStatusBars = darkStatusBarIcons
            isAppearanceLightNavigationBars = darkNavigationBarIcons
        }
    }
}



//usage
//StatusBarBackground(
//    backgroundColor = Color(0xFF121212),
//    navigationBarColor = Color.Black
//)


//or
//StatusBarBackground(
//    backgroundColor = Color.White
//)