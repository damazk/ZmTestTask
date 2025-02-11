package com.bulat.zmtesttask.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bulat.zmtesttask.R
import com.bulat.zmtesttask.core.components.CustomProgressBar
import com.bulat.zmtesttask.presentation.viewmodel.HomeViewModel
import com.bulat.zmtesttask.presentation.viewmodel.HomeViewModel.UiState

@Composable
fun SplashScreen(
    viewModel: HomeViewModel,
    navigateToWebView: (String) -> Unit,
    navigateToHome: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.sendDeviceInfoAndGetUrl()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(R.drawable.splash_bg))
            .padding(horizontal = 16.dp),
    ) {
        when (val state = uiState) {
            is UiState.WebView -> navigateToWebView(state.url)
            is UiState.Home -> navigateToHome()
            UiState.Loading -> {

                Column(
                    Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Splash",
                        modifier = Modifier.padding(top = 150.dp),
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )

                    CustomProgressBar(modifier = Modifier.padding(bottom = 100.dp))
                }
            }
        }
    }
} 