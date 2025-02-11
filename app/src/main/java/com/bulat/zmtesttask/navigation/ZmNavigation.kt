package com.bulat.zmtesttask.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bulat.zmtesttask.presentation.compose.HomeScreen
import com.bulat.zmtesttask.presentation.compose.InfoScreen
import com.bulat.zmtesttask.presentation.compose.QuizScreen
import com.bulat.zmtesttask.presentation.compose.SplashScreen
import com.bulat.zmtesttask.presentation.compose.WebViewScreen

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object WebView : Screen("webview/{url}") {
        fun createRoute(url: String) = "webview/$url"
    }
    object MainMenu : Screen("main_menu")
    object Info : Screen("info")
    object Quiz : Screen("quiz")
}

@Composable
fun ZmNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(
                viewModel = hiltViewModel(),
                navigateToWebView = { url ->
                    navController.navigate(Screen.WebView.createRoute(url)) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                },
                navigateToHome = {
                    navController.navigate(Screen.MainMenu.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(
            Screen.WebView.route,
            arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) { backStackEntry ->
            val url = backStackEntry.arguments?.getString("url")
            WebViewScreen(url = url ?: "")
        }
        
        composable(Screen.MainMenu.route) {
            HomeScreen(
                onInfoClick = { navController.navigate(Screen.Info.route) },
                onQuizClick = { navController.navigate(Screen.Quiz.route) }
            )
        }
        
        composable(Screen.Info.route) {
            InfoScreen(
                onBackClick = { navController.navigateUp() }
            )
        }
        
        composable(Screen.Quiz.route) {
            QuizScreen(onBackClick = { navController.navigateUp() })
        }
    }
} 